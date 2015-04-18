package com.ud.spirit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.ImageView;

import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.google.vrtoolkit.cardboard.Eye;
import com.google.vrtoolkit.cardboard.HeadTransform;
import com.google.vrtoolkit.cardboard.Viewport;

import javax.microedition.khronos.egl.EGLConfig;


/**
 * A Cardboard sample application.
 */
public class Mars12Activity extends CardboardActivity implements
        CardboardView.StereoRenderer {

    private static final String TAG = "Spirit";

    Uri fileUri = null;
    ImageView photoImage = null;

    private int mScore = 12;

    private Vibrator mVibrator;

    private CardboardOverlayView mOverlayView;

    /**
     * Sets the view to our CardboardView and initializes the transformation
     * matrices we will use to render our scene. //@param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        CardboardView cardboardView = (CardboardView) findViewById(R.id.cardboard_view1);
        cardboardView.setRenderer(this);
        setCardboardView(cardboardView);

        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        mOverlayView = (CardboardOverlayView) findViewById(R.id.overlay);

        //mOverlayView.show3DSplashImage();
        Log.i(TAG, "onCreate:: before show3DImage");
        mOverlayView.show3DImage(mScore, Mars12Activity.this);
    }



    @Override
    public void onCardboardTrigger() {
        Log.i(TAG, "onRendererShutdown1");
        Log.i(TAG, "inside onCardboardTrigger, score="+mScore);
        mVibrator.vibrate(50);
        Intent intent = new Intent(Mars12Activity.this, Mars13Activity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onRendererShutdown() {
        Log.i(TAG, "onRendererShutdown");
    }

    @Override
    public void onSurfaceChanged(int width, int height) {
        Log.i(TAG, "onSurfaceChanged");
    }

    /**
     * Creates the buffers we use to store information about the 3D world.
     * OpenGL doesn't use Java arrays, but rather needs data in a format it can
     * understand. Hence we use ByteBuffers.
     *
     * @param config
     *            The EGL configuration used when creating the surface.
     */
    @Override
    public void onSurfaceCreated(EGLConfig config) {
        Log.i(TAG, "onSurfaceCreated");
    }

    /**
     * Prepares OpenGL ES before we draw a frame.
     *
     * @param headTransform
     *            The head transformation in the new frame.
     */
    @Override
    public void onNewFrame(HeadTransform headTransform) {
    }

    /**
     * Draws a frame for an eye. The transformation for that eye (from the
     * camera) is passed in as a parameter.
     *
     * @param transform
     *            The transformations to apply to render this eye.
     */
    @Override
    public void onDrawEye(Eye transform) {
    }

    @Override
    public void onFinishFrame(Viewport viewport) {
    }

}

