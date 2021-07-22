//程序传入的顶点属性组
attribute vec4 position;
//程序传入的纹理坐标
attribute vec4 texcoord;
uniform mat4 U_ModelMatrix;
uniform mat4 U_ViewMatrix;
uniform mat4 U_ProjectionMatrix;
varying vec4 V_Texcoord;
void main(){
    V_Texcoord=texcoord;
    gl_Position=U_ProjectionMatrix*U_ViewMatrix*U_ModelMatrix*position;
}