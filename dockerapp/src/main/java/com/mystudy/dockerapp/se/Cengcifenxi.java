package com.mystudy.dockerapp.se;

public class Cengcifenxi {
    /**
     *
     *@author LJ
     *2016-3-30
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Double[][] matrix=new Double[6][6];
        for(int i=0;i<6;i++){
            matrix[i][i]=1.0;
        }


        //数组0,1 位置存放的是影响因素0相对于影响因素1的重要程度 。
        //0.25代表 影响因素0的重要程度为影响因素1的重要程度的4分之1。
        matrix[0][1]=0.25;
        matrix[0][2]=0.5;
        matrix[0][3]=1.0;
        matrix[0][4]=1.0;
        matrix[0][5]=0.5;
        matrix[1][2]=0.5;
        matrix[1][3]=1.0;
        matrix[1][4]=2.0;
        matrix[1][5]=1.0;
        matrix[2][3]=1.0;
        matrix[2][4]=0.5;
        matrix[2][5]=0.5;
        matrix[3][4]=2.0;
        matrix[3][5]=1.0;
        matrix[4][5]=0.5;
        //根据输入值填写矩阵剩余项
        for(int i=5;i>=0;i--){
            for(int j=5;j>=0;j--){
                matrix[i][j]=1/matrix[j][i];
            }
        }
        Double[] column=new Double[6];
        for(int j=0;j<6;j++){
            for(int i=0;i<6;i++){
                if(column[j]!=null){
                    column[j]=column[j]+matrix[i][j];
                }else{
                    column[j]=matrix[i][j];
                }
            }

        }
        //矩阵归一化
        Double[][] matrixColumn= new Double[6][6];
        for(int j=0;j<6;j++){
            for(int i=0;i<6;i++){
                matrixColumn[i][j]=matrix[i][j]/column[j];
            }

        }
        //获得行数组
        Double[] line=new Double[6];
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(line[i]!=null){
                    line[i]=line[i]+matrixColumn[i][j];
                }else{
                    line[i]=matrixColumn[i][j];
                }
            }

        }
        //行归一化获得特征向量
        Double[] w=new Double[6];
        Double sum=0.0;
        for(int i=0;i<6;i++){
            sum=sum+line[i];
        }
        for(int i=0;i<6;i++){
            w[i]=line[i]/sum;                    //特征向量
        }
        Double[] bw=new Double[6];
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(bw[i]!=null){
                    bw[i]=bw[i]+matrix[i][j]*w[j];
                }else{
                    bw[i]=matrix[i][j]*w[j];
                }
            }
        }
        Double sumR=0.0;                        //最大特征跟R
        for(int i=0;i<6;i++){
            sumR=sumR+bw[i]/(6*w[i]);
        }
        Double ci=(sumR-6)/(6-1);                //矩阵一致性指标
        System.out.println("计算出的矩阵一致性指标"+ci+"\n");
        Double cr=ci/1.24;                        //随机一致性比率 1.24为6阶矩阵的平均一致性指标
        if(cr>=0.1){
            System.out.println("权重设置不合理");
        }else{
            //输出特征向量
            for(int i=0;i<6;i++){
                System.out.println("特征"+i+"的权重："+w[i]);
            }
        }
    }

}