package com.example.makeupbeauty.ui.TryOn;

import static com.example.makeupbeauty.ui.TryOn.ShaderUtil.loadGLShader;
import static com.example.makeupbeauty.ui.TryOn.ShaderUtil.loadTexture;

import android.content.Context;
import android.opengl.GLES20;

import com.google.common.collect.ImmutableSet;
import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.solutioncore.ResultGlRenderer;
import com.google.mediapipe.solutions.facemesh.FaceMeshConnections;
import com.google.mediapipe.solutions.facemesh.FaceMeshResult;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

public class FacialTry implements ResultGlRenderer<FaceMeshResult> {
    private static final String TAG = "FaceMeshResultGlRenderer";
    private static float[] BROWS_COLOR = new float[] {0.9f, 0.9f, 0.9f, 1f};
    private static float[] LIPS_COLOR = new float[] {0.98f, 0.502f, 0.447f, .9f};
    private final int[] textureId = new int[1];

    private static final String VERTEX_SHADER = "shaders/object.vert";
    private static final String FRAGMENT_SHADER = "shaders/object.frag";
    private int program;
    private int modelViewProjectionUniform;
    private int textureUniform;

    private int materialParametersUniform;

    private int colorCorrectionParameterUniform;

    private int tintColorUniform;
    private int attriVertices;
    private int attriUvs;

    private int modelViewUniform;
    private int lightingParametersUniform;
    private int attriNormals;

    // Set some default material properties to use for lighting.
    private float ambient = 0.3f;
    private float diffuse = 1.0f;
    private float specular = 1.0f;
    private float specularPower = 6.0f;
    private Context context;
    private boolean lips_deepmode = true;
    private boolean brows_deepmode = true;
    private boolean putLip = false;
    private boolean putBrow = false;

    public FacialTry(Context context) {
        this.context = context;
    }

    public void setLipsColor(float r,float g,float b,float a){
        r /= 255.0;
        g /= 255.0;
        b /= 255.0;
        LIPS_COLOR[0] = r;
        LIPS_COLOR[1] = g;
        LIPS_COLOR[2] = b;
        LIPS_COLOR[3] = a;
    }

    public void setBrowsColor(float r,float g,float b,float a){
        r /= 255.0;
        g /= 255.0;
        b /= 255.0;
        BROWS_COLOR[0] = r;
        BROWS_COLOR[1] = g;
        BROWS_COLOR[2] = b;
        BROWS_COLOR[3] = a;
    }

    public void setPutLip(boolean putLip) {
        this.putLip = putLip;
    }

    public void setPutBrow(boolean putBrow) {
        this.putBrow = putBrow;
    }

    public void setLips_deepmode() {
        lips_deepmode = !lips_deepmode;
    }

    public void setBrows_deepmode() {
        brows_deepmode = !brows_deepmode;
    }

    public boolean isLips_deepmode() {
        return lips_deepmode;
    }

    public boolean isBrows_deepmode() {
        return brows_deepmode;
    }

    @Override
    public void setupRendering() {
        program = GLES20.glCreateProgram();
        int vertexShader = loadGLShader(context,GLES20.GL_VERTEX_SHADER, VERTEX_SHADER);
        int fragmentShader = loadGLShader(context,GLES20.GL_FRAGMENT_SHADER, FRAGMENT_SHADER);
        GLES20.glAttachShader(program, vertexShader);
        GLES20.glAttachShader(program, fragmentShader);
        GLES20.glLinkProgram(program);
        modelViewProjectionUniform = GLES20.glGetUniformLocation(program, "u_ModelViewProjection");
        modelViewUniform = GLES20.glGetUniformLocation(program, "u_ModelView");
        textureUniform = GLES20.glGetUniformLocation(program, "u_Texture");

        lightingParametersUniform = GLES20.glGetUniformLocation(program, "u_LightningParameters");
        materialParametersUniform = GLES20.glGetUniformLocation(program, "u_MaterialParameters");
        colorCorrectionParameterUniform =
                GLES20.glGetUniformLocation(program, "u_ColorCorrectionParameters");
        tintColorUniform = GLES20.glGetUniformLocation(program, "u_TintColor");

        attriVertices = GLES20.glGetAttribLocation(program, "a_Position");
        attriUvs = GLES20.glGetAttribLocation(program, "a_TexCoord");
        attriNormals = GLES20.glGetAttribLocation(program, "a_Normal");
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glGenTextures(1, textureId, 0);
        loadTexture(context, textureId, "models/c.PNG");
    }

    @Override
    public void renderResult(FaceMeshResult result, float[] projectionMatrix) {
        if (result == null) {
            return;
        }

        GLES20.glUseProgram(program);
        GLES20.glUniform4f(materialParametersUniform, ambient, diffuse, specular, specularPower);
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glUniform1i(textureUniform, 0);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId[0]);
        GLES20.glUniform4f(tintColorUniform, 0, 0, 0, 0);

        GLES20.glUniformMatrix4fv(modelViewProjectionUniform, 1, false, projectionMatrix, 0);

        int numFaces = result.multiFaceLandmarks().size();
        for (int i = 0; i < numFaces; ++i) {
            if(putLip){
                drawLips(
                        result.multiFaceLandmarks().get(i).getLandmarkList(),
                        LIPS_COLOR);
            }
            if(putBrow){
                drawBrows(
                        result.multiFaceLandmarks().get(i).getLandmarkList(),
                        BROWS_COLOR);
            }
        }
    }

    /**
     * Deletes the shader program.
     *
     * <p>This is only necessary if one wants to release the program while keeping the context around.
     */
    public void release() {
        GLES20.glDeleteProgram(program);
    }

    private void drawLips(
            List<LandmarkProto.NormalizedLandmark> faceLandmarkList,
            float[] colorArray) {

        GLES20.glUniform4fv(colorCorrectionParameterUniform, 1, colorArray, 0);

        int[] lipver = new int[]{61,78,185,191,40,80,39,81,37,82,0,13,267,312,269,311,270,310,409,415,306,308};
        int[] lip_dwn = new int[]{61,78,146,95,91,88,181,178,84,87,17,14,314,317,405,402,321,318,375,324,306,308};

        float[] texture = new float[]{
                0.1f,0f,
                0.5f,0f,
                0.1f,0.1f,
                0.5f,0.1f,
                0.1f,0.2f,
                0.5f,0.2f,
                0.1f,0.3f,
                0.5f,0.3f,
                0.1f,0.4f,
                0.5f,0.4f,
                0.1f,0.5f,
                0.5f,0.5f,
                0.1f,0.6f,
                0.5f,0.6f,
                0.1f,0.7f,
                0.5f,0.7f,
                0.1f,0.8f,
                0.5f,0.8f,
                0.1f,0.9f,
                0.5f,0.9f,
                0.1f,1f,
                0.5f,1f
        };
        int count = 0,inc = 0;
        float[] vertex = new float[lipver.length*3];
        float[] vertex_dwn = new float[lip_dwn.length*3];
        short[] index = new short[lipver.length*6];
        for (int i: lipver) {
            LandmarkProto.NormalizedLandmark start = faceLandmarkList.get(i);
            vertex[count++] = start.getX();
            vertex[count++] = start.getY();
            vertex[count++] = start.getZ();
        }
        count =0;
        for (int i: lip_dwn) {
            LandmarkProto.NormalizedLandmark start = faceLandmarkList.get(i);
            vertex_dwn[count++] = start.getX();
            vertex_dwn[count++] = start.getY();
            vertex_dwn[count++] = start.getZ();
        }

        for(int i = 2; i < lipver.length;i++){
            index[inc++] = (short)(i-2);
            index[inc++] = (short)(i-1);
            index[inc++] = (short)(i);
        }

        FloatBuffer vertexBuffer = floatBufferUtil(vertex);
        FloatBuffer verdwnBuffer = floatBufferUtil(vertex_dwn);
        FloatBuffer textureCoords = floatBufferUtil(texture);

        ShortBuffer indexBuffer = shortBufferUtil(index);
        GLES20.glEnable(GLES20.GL_BLEND);
        GLES20.glEnableVertexAttribArray(attriVertices);
        GLES20.glVertexAttribPointer(attriVertices, 3, GLES20.GL_FLOAT, false, 0, vertexBuffer);
        GLES20.glEnableVertexAttribArray(attriUvs);
        GLES20.glVertexAttribPointer(attriUvs, 2, GLES20.GL_FLOAT, false, 0, textureCoords);

        GLES20.glDepthMask(true);
        if(lips_deepmode){
            GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_DST_COLOR);
        }else{
            GLES20.glBlendFunc(GLES20.GL_ONE, GLES20.GL_SRC_ALPHA);
        }

        GLES20.glDrawElements(
                GLES20.GL_TRIANGLES, indexBuffer.limit(), GLES20.GL_UNSIGNED_SHORT, indexBuffer);

        GLES20.glEnableVertexAttribArray(attriVertices);
        GLES20.glVertexAttribPointer(attriVertices, 3, GLES20.GL_FLOAT, false, 0, verdwnBuffer);
        GLES20.glDrawElements(
                GLES20.GL_TRIANGLES, indexBuffer.limit(), GLES20.GL_UNSIGNED_SHORT, indexBuffer);

        GLES20.glDisable(GLES20.GL_BLEND);
        GLES20.glDepthMask(true);
    }

    public void drawBrows(
            List<LandmarkProto.NormalizedLandmark> faceLandmarkList,
            float[] colorArray){
        GLES20.glUniform4fv(colorCorrectionParameterUniform, 1, colorArray, 0);

        int lipver[] = new int[]{70,63,53,105,52,66,65,107,55};
        int lip_dwn[] = new int[]{300,293,283,334,282,296,295,336,285};
        float[] texture = new float[]{
                0.1f,0f,
                0.3f,0f,
                0.3f,1f,
                0.5f,0f,
                0.5f,1f,
                0.7f,0f,
                0.7f,1f,
                0.9f,0f,
                0.9f,1f
        };
        int count = 0,inc = 0;
        float[] vertex = new float[lipver.length*3];
        float[] vertex_dwn = new float[lip_dwn.length*3];
        short[] index = new short[lipver.length*6];
        for (int i: lipver) {
            LandmarkProto.NormalizedLandmark start = faceLandmarkList.get(i);
            if(i == 107){
                LandmarkProto.NormalizedLandmark end = faceLandmarkList.get(55);
                vertex[count++] = (start.getX()+end.getX())/2;
                vertex[count++] = (start.getY()+end.getY())/2;
                vertex[count++] = (start.getZ()+end.getZ())/2;
            }else{
                vertex[count++] = start.getX();
                vertex[count++] = start.getY();
                vertex[count++] = start.getZ();
            }

        }
        count =0;
        for (int i: lip_dwn) {
            LandmarkProto.NormalizedLandmark start = faceLandmarkList.get(i);
            if(i == 336){
                LandmarkProto.NormalizedLandmark end = faceLandmarkList.get(285);
                vertex_dwn[count++] = (start.getX()+end.getX())/2;
                vertex_dwn[count++] = (start.getY()+end.getY())/2;
                vertex_dwn[count++] = (start.getZ()+end.getZ())/2;
            }else{
                vertex_dwn[count++] = start.getX();
                vertex_dwn[count++] = start.getY();
                vertex_dwn[count++] = start.getZ();
            }

        }

        for(int i = 2; i < lipver.length;i++){
            index[inc++] = (short)(i-2);
            index[inc++] = (short)(i-1);
            index[inc++] = (short)(i);
        }

        FloatBuffer vertexBuffer = floatBufferUtil(vertex);
        FloatBuffer verdwnBuffer = floatBufferUtil(vertex_dwn);
        FloatBuffer textureCoords = floatBufferUtil(texture);
        ShortBuffer indexBuffer = shortBufferUtil(index);
        GLES20.glEnable(GLES20.GL_BLEND);
        GLES20.glEnableVertexAttribArray(attriVertices);
        GLES20.glVertexAttribPointer(attriVertices, 3, GLES20.GL_FLOAT, false, 0, vertexBuffer);
        GLES20.glEnableVertexAttribArray(attriUvs);
        GLES20.glVertexAttribPointer(attriUvs, 2, GLES20.GL_FLOAT, false, 0, textureCoords);

        GLES20.glDepthMask(true);
        if(brows_deepmode){
            GLES20.glBlendFunc(GLES20.GL_ONE, GLES20.GL_SRC_ALPHA);
        }else{
            GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_DST_COLOR);
        }
        GLES20.glDrawElements(
                GLES20.GL_TRIANGLES, indexBuffer.limit(), GLES20.GL_UNSIGNED_SHORT, indexBuffer);

        GLES20.glEnableVertexAttribArray(attriVertices);
        GLES20.glVertexAttribPointer(attriVertices, 3, GLES20.GL_FLOAT, false, 0, verdwnBuffer);
        GLES20.glDrawElements(
                GLES20.GL_TRIANGLES, indexBuffer.limit(), GLES20.GL_UNSIGNED_SHORT, indexBuffer);

        GLES20.glDisable(GLES20.GL_BLEND);
        GLES20.glDepthMask(true);
    }

    public void setMaterialProperties(
            float ambient, float diffuse, float specular, float specularPower) {
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.specularPower = specularPower;
    }

    private static FloatBuffer floatBufferUtil(float[] arr)
    {
        FloatBuffer mBuffer;
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个int占4个字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        // 数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());
        mBuffer = qbb.asFloatBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }

    private static ShortBuffer shortBufferUtil(short[] arr){
        ShortBuffer mBuffer;
        // 初始化ByteBuffer，长度为arr数组的长度*2，因为一个short占2个字节
        ByteBuffer dlb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 2 bytes per short)
                arr.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        mBuffer = dlb.asShortBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }
}
