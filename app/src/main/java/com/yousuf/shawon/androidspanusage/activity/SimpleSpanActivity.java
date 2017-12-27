package com.yousuf.shawon.androidspanusage.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AlignmentSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.yousuf.shawon.androidspanusage.R;

public class SimpleSpanActivity extends AppCompatActivity {

  @Bind(R.id.textView1) TextView textView1;
  @Bind(R.id.textView2) TextView textView2;
  @Bind(R.id.textView3) TextView textView3;
  @Bind(R.id.textView4) TextView textView4;
  @Bind(R.id.textView5) TextView textView5;
  @Bind(R.id.textView6) TextView textView6;
  @Bind(R.id.textView7) TextView textView7;
  @Bind(R.id.textView8) TextView textView8;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_span);
    ButterKnife.bind(this);

    generateBoldSpan();

    generateImageSpan();

    generateLinkSpan();

    generateAlignmentSpan();

    generateUnderlineSpan();

    generateStrikethroughSpan();

    String str1 = getString(R.string.sample_text_4);

    generateSpan(textView7, str1, new SubscriptSpan(), "greater" );
    generateSpan(textView8, str1, new SuperscriptSpan(), "greater" );


  }

  private void generateImageSpan() {

    String str = "This line added a smiley to the end ";
    int startIndex = str.length();
    int endIndex = startIndex + +1;

    SpannableStringBuilder ssb = new SpannableStringBuilder(str + " ");

    Bitmap smiley = BitmapFactory.decodeResource(getResources(), R.drawable.emoticon);
    ssb.setSpan(new ImageSpan(smiley), startIndex, endIndex, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
    textView2.setText(ssb, TextView.BufferType.SPANNABLE);
  }

  private void generateBoldSpan() {

    String searchStr = "bold";
    int startIndex = textView1.getText().toString().toLowerCase().indexOf(searchStr);
    int endIndex = startIndex + searchStr.length();

    Spannable spannable = (Spannable) textView1.getText();
    StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
    spannable.setSpan(boldSpan, startIndex, endIndex, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
  }

  private void generateLinkSpan() {

    String str = getString(R.string.sample_text_2);
    String strSite = getString(R.string.android_site_link);
    String strText = str + " " + strSite;
    SpannableStringBuilder ssb = new SpannableStringBuilder(strText);
    int startIndex = str.length() + 1;
    int endIndex = startIndex + strSite.length();

    URLSpan urlSpan = new URLSpan(strSite);

    ssb.setSpan(urlSpan, startIndex, endIndex, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
    textView3.setText(ssb, TextView.BufferType.SPANNABLE);
    textView3.setMovementMethod(LinkMovementMethod.getInstance());
  }

  private void generateAlignmentSpan(){
    String str = getString(R.string.sample_text_3);
    AlignmentSpan alignmentSpan =  new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);

    SpannableString mSpannableString = new SpannableString(str);
    mSpannableString.setSpan(alignmentSpan, 0, str.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    textView4.setText(mSpannableString, TextView.BufferType.SPANNABLE);

  }


  private void generateUnderlineSpan(){
    String str = getString(R.string.sample_text_3);
    UnderlineSpan underlineSpan =  new UnderlineSpan();

    SpannableString mSpannableString = new SpannableString(str);
    mSpannableString.setSpan(underlineSpan, str.length()/2 - 10, str.length()/2 + 10, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

    textView5.setText(mSpannableString, TextView.BufferType.SPANNABLE);

  }


  private void generateStrikethroughSpan(){
    String str = getString(R.string.sample_text_3);
    StrikethroughSpan underlineSpan =  new StrikethroughSpan();

    SpannableString mSpannableString = new SpannableString(str);
    mSpannableString.setSpan(underlineSpan, str.length()/2 - 10, str.length()/2 + 10, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

    textView6.setText(mSpannableString, TextView.BufferType.SPANNABLE);

  }


  private void generateSpan(TextView textView, String str, Object span, String search){

    int start = str.length()/2 - 7;
    int end = str.length()/2 + 7;

    if (str.toLowerCase().contains(search)) {
      start = str.toLowerCase().indexOf(search);
      end = start + search.length();
    }

    SpannableString mSpannableString = new SpannableString(str);
    mSpannableString.setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
    textView.setText(mSpannableString, TextView.BufferType.SPANNABLE);

  }



}
