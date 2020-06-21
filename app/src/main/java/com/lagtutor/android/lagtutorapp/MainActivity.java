package com.lagtutor.android.lagtutorapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String admissionReqUrl;
    private String utmeTargetUrl;

    private TextView admissionReqShareTextView;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        utmeTargetUrl = "http://lagtutor.com/unilag-utme-target.php";
        admissionReqUrl = "http://lagtutor.com/unilag-undergraduate-admission-requirements.php";
        // cutoffShareTextView = findViewById(R.id.cutoff_share_textView);
        admissionReqShareTextView = findViewById(R.id.admission_req_textView);
        // cutoffShareEditText = findViewById(R.id.cutoff_share_editText);

    }

    public void cutoffShareButton(View view) {
        String txt = admissionReqShareTextView.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_cutoffs)
                .setText(txt)
                .startChooser();
    }

    public void openUtmeTargetPage (View view) {
        // Get the URL text.
        String url = utmeTargetUrl;
        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }/* else {
            // Log.d("ImplicitIntents", "Can't handle this!");
        }
        */
    }

    public void openAdmissionReqPage(View view) {
        // Get the URL text.
        String url = admissionReqUrl;
        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }/* else {
            // Log.d("ImplicitIntents", "Can't handle this!");
        }
        */
    }

    public void launchContactActivity(View view) {
        Log.d(LOG_TAG, "Contact Button clicked!");
        // Intent intent = new Intent(this, SecondActivity.class);
        Intent intent   = new Intent(this, contactActivity.class);
        startActivity(intent);
    }


}
