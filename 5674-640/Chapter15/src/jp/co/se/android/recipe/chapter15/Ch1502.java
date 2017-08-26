package jp.co.se.android.recipe.chapter15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Ch1502 extends Activity {
    private static final int CODE_PICKFILE_RESULT = 1;
    private TextView mTextFilename;
    private TextView mTextContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ch1502_main);

        mTextFilename = (TextView) findViewById(R.id.textFilename);
        mTextContents = (TextView) findViewById(R.id.textContents);

        findViewById(R.id.buttonRead).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivityForResult(intent, CODE_PICKFILE_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == CODE_PICKFILE_RESULT) {
                Uri uri = data.getData();
                readFile(uri);
            }
        }
    }

    private void readFile(Uri textUrl) {
        try {
            // Uri에서 파일의 경로를 받아 File을 생성
            File file = new File(textUrl.getPath());
            mTextFilename.setText(file.getName());
            // File에서 Reader 클래스를 생성
            BufferedReader bufferReader = new BufferedReader(new FileReader(
                    file));
            String StringBuffer;
            String stringText = "";
            // 한 줄씩 읽는 String 형의 데이터를 작성
            while ((StringBuffer = bufferReader.readLine()) != null) {
                stringText += StringBuffer;
            }
            bufferReader.close();
            mTextContents.setText(stringText);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            mTextContents.setText(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            mTextContents.setText(e.toString());
        }
    }
}
