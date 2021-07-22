#ifdef GL_ES
precision mediump float;
#endif
//纹理图片
uniform sampler2D U_Texture;
//纹理坐标
varying vec4 V_Texcoord;
void main(){
    //纹理坐标从纹理图片中取出点赋值给gl_FragColor
    gl_FragColor=texture2D(U_Texture,V_Texcoord.xy);
}