#include "stdio.h"
#include "string.h"
#include "com_lpr_JniTestAndroid.h"


JNIEXPORT jbyteArray JNICALL Java_com_lpr_JniTestAndroid_recognition
(JNIEnv *jnienv, jobject jobj, jbyteArray byteArray)
{
    /*    short*  iArray ; //=new short[maxSize];
        jboolean jbool = true;
        //转换数组
        iArray = jnienv->GetShortArrayElements(shortArray, &jbool);
        //...
        //
        jnienv->ReleaseShortArrayElements(shortArray,iArray,0);
        // do something with iArray ...

        // carnumber;
    */
    char carnumber[64]= {"你输入的是:"};

    jbyteArray  returnLPRArray = jnienv->NewByteArray( 64 );
    jbyte *retbytes = jnienv->GetByteArrayElements( returnLPRArray, 0);

    jbyte *bytes2 = jnienv->GetByteArrayElements(byteArray, 0);

    sprintf(carnumber, "%s %s",carnumber, bytes2);

    int nLPRLen = strlen(carnumber);
    //返回值最好是 byte,以免utf8造成汉字的影响
    for ( int i = 0; i < nLPRLen;  i++ )
    {
        retbytes[ i ] = carnumber[ i ];
    }

    jnienv->SetByteArrayRegion(returnLPRArray, 0, nLPRLen, retbytes );

    return   returnLPRArray ;
}


