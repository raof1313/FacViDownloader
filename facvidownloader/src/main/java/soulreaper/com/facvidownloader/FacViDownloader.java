package soulreaper.com.facvidownloader;

import android.app.DownloadManager;
import android.net.Uri;

import java.util.concurrent.ExecutionException;

public class FacViDownloader {
    private String facebookVideoLink;
    public FacViDownloader(String facebookVideoLink){
        this.facebookVideoLink=facebookVideoLink;
    }


    public DownloadManager.Request getRequest(){
        if (facebookVideoLink.contains("facebook")){
            facebookVideoLink =facebookVideoLink.replace("www","mbasic");
            try {
                StringBuilder builder= (StringBuilder) new Xconnect(facebookVideoLink).execute().get();
                String link=getFaceBookLink(builder.toString());
                DownloadManager.Request request=new DownloadManager.Request(Uri.parse(link));
                return request;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }        return null;
    }

    private String getFaceBookLink(String conte){
        String cc="";

        String fullLink="";
        String firstIdOne="";
        String firstIdSecond="";
        String secondId="";
        String idOne="";
        String firstIdThird="";
        String thirdId="";
        String firstIdFourth="";
        String idfour="";
        String finalId="";
        String finalFirstId="";
        String downLink="";
        String rest="";
        int one=0;
        String something="";
        // Toast.makeText(getApplicationContext(),"one",Toast.LENGTH_LONG).show();
        for(int i=0;i < conte.length();i++){
            if (conte.charAt(i)=='/' && conte.charAt(i+1)=='v' && conte.charAt(i+2)=='i'
                    && conte.charAt(i+3)=='d'&& conte.charAt(i+4)=='e' &&conte.charAt(i+5)=='o'
                    &&conte.charAt(i+6)=='_'&&conte.charAt(i+7)=='r'
                    &&conte.charAt(i+8)=='e' && conte.charAt(i+9)=='d'
                    &&conte.charAt(i+10)=='i' &&conte.charAt(i+11)=='r'&&conte.charAt(i+12)=='e'
                    &&conte.charAt(i+13)=='c'&&conte.charAt(i+14)=='t' && conte.charAt(i+15)=='/'){
                cc=conte.substring(i);

                break;
            }

        }
        if (!cc.isEmpty()){
            for (int i=0;i < cc.length();i++){
                if (cc.charAt(i)=='"'){
                    fullLink = cc.substring(0, i);
                    break;

                }
            }

        }
        if (!fullLink.isEmpty()){
            for(int i=0;i < fullLink.length();i++){
                if (fullLink.charAt(i)=='%'&& fullLink.charAt(i+1)=='2'&& fullLink.charAt(i+2)=='F'){
                    one=one+1;
                    if (one==5) {
                        firstIdOne = fullLink.substring(i + 3);
                        idOne = firstIdOne.substring(0, firstIdOne.indexOf('.'));
                        break;
                    }

                }
            }

        }
        if (!firstIdOne.isEmpty()){
            for (int i=0;i < firstIdOne.length();i++){
                if (firstIdOne.charAt(i)=='_'&& firstIdOne.charAt(i+1)=='n'&& firstIdOne.charAt(i+2)=='c'
                        && firstIdOne.charAt(i+3)=='_' && firstIdOne.charAt(i+4)=='c'&& firstIdOne.charAt(i+5)=='a' ){
                    firstIdSecond=firstIdOne.substring(i+22);
                    secondId=firstIdSecond.substring(0,firstIdSecond.indexOf('%'));
                    break;
                }
            }


        }
        if (!firstIdSecond.isEmpty()){
            for(int i=0;i < firstIdSecond.length();i++){
                if (firstIdSecond.charAt(i)=='_' && firstIdSecond.charAt(i+1)=='n' && firstIdSecond.charAt(i+2)=='c'
                        && firstIdSecond.charAt(i+3)=='_'&&firstIdSecond.charAt(i+4)=='o'
                        && firstIdSecond.charAt(i+5)=='c' ){
                    firstIdThird=firstIdSecond.substring(i+9);
                    thirdId=firstIdThird.substring(0,firstIdThird.indexOf('%'));
                    break;
                }

            }

        }
        if (!firstIdThird.isEmpty()){
            for(int i=0;i < firstIdThird.length();i++){
                if (firstIdThird.charAt(i)=='%' && firstIdThird.charAt(i+1)=='2'
                        && firstIdThird.charAt(i+2)=='6'&& firstIdThird.charAt(i+3)=='o' && firstIdThird.charAt(i+4)=='h'){
                    firstIdFourth=firstIdThird.substring(i+8);
                    idfour=firstIdFourth.substring(0,firstIdFourth.indexOf('%'));
                    break;
                }
            }
            for (int i=0;i < firstIdThird.length();i++){
                if (firstIdThird.charAt(i)=='_'&&firstIdThird.charAt(i+1)=='n'&& firstIdThird.charAt(i+2)=='c'
                        &&firstIdThird.charAt(i+3)=='_'&& firstIdThird.charAt(i+4)=='h' && firstIdThird.charAt(i+5)=='t'){
                    String rest1=firstIdThird.substring(i+9);
                    rest=rest1.substring(0,rest1.indexOf('%'));
                    break;
                }
            }        }
        if (!firstIdFourth.isEmpty()){
            for(int i=0;i <firstIdFourth.length();i++){
                if (firstIdFourth.charAt(i)=='%' && firstIdFourth.charAt(i+1)=='2' && firstIdFourth.charAt(i+2)=='6'
                        && firstIdFourth.charAt(i+3)=='o'&& firstIdFourth.charAt(i+4)=='e'){
                    finalFirstId=firstIdFourth.substring(i+8);
                    finalId=finalFirstId.substring(0,finalFirstId.indexOf('&'));
                    break;
                }
            }
        }
        String cat="";
        String www="";
        if(!fullLink.isEmpty()){
            String www1="";
            for(int i=0;i < fullLink.length();i++){
                if (fullLink.charAt(i)=='_' && fullLink.charAt(i+1)=='n'&&fullLink.charAt(i+2)=='c'
                        &&fullLink.charAt(i+3)=='_'&&fullLink.charAt(i+4)=='c'&&fullLink.charAt(i+5)=='a'
                        &&fullLink.charAt(i+6)=='t'){
                    String cat1=fullLink.substring(i+10);
                    cat=cat1.substring(0,cat1.indexOf('%'));

                    break;
                }
            }

            for (int i=0;i <fullLink.length();i++){
                if (fullLink.charAt(i)=='h'&&fullLink.charAt(i+1)=='t'&&fullLink.charAt(i+2)=='t'
                        && fullLink.charAt(i+3)=='p'&&fullLink.charAt(i+4)=='s'){

                    www1 = fullLink.substring(i+5);

                    break;
                }

            }
            int two=0;
            String www2="";
            for (int i=0;i < www1.length();i++){

                if (www1.charAt(i)=='%'&&www1.charAt(i+1)=='2'&&www1.charAt(i+2)=='F'){
                    two=two+1;
                    if (two==2) {
                        www2 = www1.substring(i+3);
                        www = www2.substring(0, www2.indexOf('%'));
                        break;
                    }
                }

            }
            int three=0;
            for (int i=0;i < www2.length();i++){
                if (www2.charAt(i)=='%'&&www2.charAt(i+1)=='2'&&www2.charAt(i+2)=='F') {
                    three=three+1;
                    if (three==2){
                        String something1=www2.substring(i+3);
                        something=something1.substring(0,something1.indexOf('%'));


                    }                }
            }        }



        if (!idOne.isEmpty() && !secondId.isEmpty() && !thirdId.isEmpty()&& !idfour.isEmpty()&&!finalId.isEmpty()){
            downLink="https://"+www+"/v/"+something+"/"+idOne+
                    ".mp4?_nc_cat="+cat+"&efg="+secondId+"&_nc_oc="+thirdId+"&_nc_ht="+rest+"&oh="
                    +idfour+"&oe="+finalId;
        }else {
            downLink="fuck";
        }
        return downLink;
    }
}
