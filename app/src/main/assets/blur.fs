#ifdef GL_ES
precision mediump float;
#endif
//纹理图片
uniform sampler2D U_Texture;
//纹理坐标
varying vec4 V_Texcoord;
//图片大小
uniform vec4 U_ImageSize;
void main(){
    vec3 color=vec3(0.0);
    //半径一个像素
    float radius_in_pixel=1.0;
    //分辨率换算纹理坐标比例,一个像素偏移在纹理坐标s,t方向是多少
    float radius_intexcoord_s=radius_in_pixel/U_ImageSize.x;
    float radius_intexcoord_t=radius_in_pixel/U_ImageSize.y;
    //增加算子权重
    float kerne[9];
    kerne[0]=1.0;kerne[1]=2.0;kerne[2]=1.0;
    kerne[3]=2.0;kerne[4]=4.0;kerne[5]=2.0;
    kerne[6]=1.0;kerne[7]=2.0;kerne[8]=1.0;


    //计算周围位置
    for(int y=-1;y<=1;y++){
        for(int x=-1;x<=1;x++){
           //算子索引
           int index=1+x+(y+1)*3;
           //当前点纹理坐标位置
           float texcoord_x=V_Texcoord.x+float(x)*radius_intexcoord_s;
           float texcoord_y=V_Texcoord.y+float(y)*radius_intexcoord_t;
           color+=texture2D(U_Texture,vec2(texcoord_x,texcoord_y)).rgb*kerne[index];
        }
    }

    color/=16.0;
    //纹理坐标从纹理图片中取出点赋值给gl_FragColor
    gl_FragColor=vec4(color,texture2D(U_Texture,V_Texcoord.xy).a);
}