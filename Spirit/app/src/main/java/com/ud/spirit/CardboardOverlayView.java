package com.ud.spirit;

/**
 * Created by uditgupta on 4/12/15.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Contains two sub-views to provide a simple stereo HUD.
 */
public class CardboardOverlayView extends LinearLayout {
    private static final String TAG = CardboardOverlayView.class
            .getSimpleName();
    private final CardboardOverlayEyeView mLeftView;
    private final CardboardOverlayEyeView mRightView;
    private AlphaAnimation mTextFadeAnimation;
    private int mScore = 0;

    public CardboardOverlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT, 1.0f);
        params.setMargins(0, 0, 0, 0);

        mLeftView = new CardboardOverlayEyeView(context, attrs);
        mLeftView.setLayoutParams(params);
        addView(mLeftView);

        mRightView = new CardboardOverlayEyeView(context, attrs);
        mRightView.setLayoutParams(params);
        addView(mRightView);

        // Set some reasonable defaults.
        setDepthOffset(0.016f);
        setColor(Color.rgb(150, 255, 180));
        setVisibility(View.VISIBLE);

        mTextFadeAnimation = new AlphaAnimation(1.0f, 0.0f);
        mTextFadeAnimation.setDuration(5000);
    }

    public void show3DToast(String message) {
        setText(message);
        setTextAlpha(1f);
        mTextFadeAnimation.setAnimationListener(new EndAnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                setTextAlpha(0f);
            }
        });
        startAnimation(mTextFadeAnimation);
    }

//    public void xyz(Context context) {
//        Log.i(TAG, "show3DImage:: begin score = %d"+ mScore);
//        long time, endTime;
//        while(mScore < 6){
//            time = System.currentTimeMillis();
//            endTime = time + 10000;
//            Log.i(TAG, "show3DImage:: begin time = %lf"+ time + "end time = %lf" + endTime);
//            if(System.currentTimeMillis() < endTime){
//                setImg(mScore, context);
//                mScore++;
//            }
//        }
//    }

    public void show3DImage(int score, Context context) {
        setImg(score, context);
    }

//    public void show3DSplashImage() {
//        setImgSplash();
//
//    }

//    private void setImgSplash() {
//        mLeftView.imageView.setLayoutParams(new LayoutParams(
//                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//        mLeftView.imageView.setBackgroundResource(R.drawable.left);
//        mRightView.imageView.setLayoutParams(new LayoutParams(
//                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//        mRightView.imageView.setBackgroundResource(R.drawable.right);
//    }

    private abstract class EndAnimationListener implements
            Animation.AnimationListener {
        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }
    }

    private void setDepthOffset(float offset) {
        mLeftView.setOffset(offset);
        mRightView.setOffset(-offset);
    }

    // ---------------------------------------------------------------------------------------------
    private void setImg(int score, Context context) {

        Log.i(TAG, "setImg:: begin score="+ score);
        switch (score) {
            case 0:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l1);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r1);
                break;
            case 1:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l3);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r3);
                break;
            case 2:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l4);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r4);
                break;
            case 3:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l5);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r5);
                break;
            case 4:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l6);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r6);
                break;
            case 5:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l7);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r7);

                break;
            case 6:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l8);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r8);
                break;
            case 7:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l9);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r9);
                break;
            case 8:
                mLeftView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mLeftView.imageView.setBackgroundResource(R.drawable.l10);
                mRightView.imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                mRightView.imageView.setBackgroundResource(R.drawable.r10);
                break;
//            case 9:
//                mLeftView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mLeftView.imageView.setBackgroundResource(R.drawable.l10);
//                mRightView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mRightView.imageView.setBackgroundResource(R.drawable.r10);
//                break;
//            case 10:
//                mLeftView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mLeftView.imageView.setBackgroundResource(R.drawable.l11);
//                mRightView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mRightView.imageView.setBackgroundResource(R.drawable.r11);
//                break;
//            case 11:
//                mLeftView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mLeftView.imageView.setBackgroundResource(R.drawable.l12);
//                mRightView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mRightView.imageView.setBackgroundResource(R.drawable.r12);
//                break;
//            case 12:
//                mLeftView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mLeftView.imageView.setBackgroundResource(R.drawable.l13);
//                mRightView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mRightView.imageView.setBackgroundResource(R.drawable.r13);
//
//                break;
//            case 13:
//                mLeftView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mLeftView.imageView.setBackgroundResource(R.drawable.l14);
//                mRightView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mRightView.imageView.setBackgroundResource(R.drawable.r14);
//                break;
//            case 14:
//                mLeftView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mLeftView.imageView.setBackgroundResource(R.drawable.l15);
//                mRightView.imageView.setLayoutParams(new LayoutParams(
//                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//                mRightView.imageView.setBackgroundResource(R.drawable.r15);
//                break;
            default:

                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);

        }
    }

    // ------------------------------------------------------------------------------------------

    private void setText(String text) {
        mLeftView.setText(text);
        mRightView.setText(text);
    }

    private void setTextAlpha(float alpha) {
        mLeftView.setTextViewAlpha(alpha);
        mRightView.setTextViewAlpha(alpha);
    }

    private void setColor(int color) {
        mLeftView.setColor(color);
        mRightView.setColor(color);
    }

    /**
     * A simple view group containing some horizontally centered text underneath
     * a horizontally centered image.
     *
     * This is a helper class for CardboardOverlayView.
     */
    private class CardboardOverlayEyeView extends ViewGroup {
        private final ImageView imageView;
        private final TextView textView;
        private float offset;

        public CardboardOverlayEyeView(Context context, AttributeSet attrs) {
            super(context, attrs);
            imageView = new ImageView(context, attrs);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setAdjustViewBounds(true); // Preserve aspect ratio.
            addView(imageView);

            textView = new TextView(context, attrs);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14.0f);
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
            textView.setGravity(Gravity.CENTER);
            textView.setShadowLayer(3.0f, 0.0f, 0.0f, Color.DKGRAY);
            addView(textView);
        }

        public void setColor(int color) {
            // imageView.setColorFilter(color);
            textView.setTextColor(color);
        }

        public void setText(String text) {
            textView.setText(text);
        }

        public void setTextViewAlpha(float alpha) {
            textView.setAlpha(alpha);
        }

        public void setOffset(float offset) {
            this.offset = offset;
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right,
                                int bottom) {
            // Width and height of this ViewGroup.
            final int width = right - left;
            final int height = bottom - top;

            // The size of the image, given as a fraction of the dimension as a
            // ViewGroup. We multiply
            // both width and heading with this number to compute the image's
            // bounding box. Inside the
            // box, the image is the horizontally and vertically centered.
            final float imageSize = 1.0f;

            // The fraction of this ViewGroup's height by which we shift the
            // image off the ViewGroup's
            // center. Positive values shift downwards, negative values shift
            // upwards.
            // final float verticalImageOffset = -0.07f;
            final float verticalImageOffset = -0.00f;

            // Vertical position of the text, specified in fractions of this
            // ViewGroup's height.
            final float verticalTextPos = 0.52f;

            // Layout ImageView
            float imageMargin = (1.0f - imageSize) / 2.0f;
            float leftMargin = (int) (width * (imageMargin + offset));
            float topMargin = (int) (height * (imageMargin + verticalImageOffset));
            imageView.layout((int) leftMargin, (int) topMargin,
                    (int) (leftMargin + width * imageSize),
                    (int) (topMargin + height * imageSize));

            // Layout TextView
            leftMargin = offset * width;
            topMargin = height * verticalTextPos;
            textView.layout((int) leftMargin, (int) topMargin,
                    (int) (leftMargin + width), (int) (topMargin + height
                            * (1.0f - verticalTextPos)));
        }
    }
}