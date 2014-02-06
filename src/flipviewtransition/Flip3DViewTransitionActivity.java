package flipviewtransition;

/**
 * Copyright (c) 2012 Ephraim Tekle genzeb@gmail.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 * associated documentation files (the "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the 
 * following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial 
 * portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN 
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 *  @author Ephraim A. Tekle
 *
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.tekle.oss.android.animation.AnimationFactory;
import com.tekle.oss.android.animation.AnimationFactory.FlipDirection;
import com.tekle.oss.android.flipviewtransition.R;

public class Flip3DViewTransitionActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		final ViewAnimator viewAnimator = (ViewAnimator) this
				.findViewById(R.id.viewFlipper);
		//((WebView) this.findViewById(R.id.front)) .loadUrl("file:///android_asset/index.html");
		((WebView) this.findViewById(R.id.back)).loadUrl("file:///android_asset/index.html");
		
		//((WebView) this.findViewById(R.id.back)).setBackgroundColor(0x0c00aa00);
		//((WebView) this.findViewById(R.id.front)).setBackgroundColor(0x00000000);
		/**
		 * Bind a click listener to initiate the flip transitions
		 */
		viewAnimator.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// This is all you need to do to 3D flip
				AnimationFactory.flipTransition(viewAnimator,
						FlipDirection.RIGHT_LEFT);
			}
		});

		// The following click listeners are not needed (only here to test that
		// clicks
		// are routed to the correct subview of the view animator).
		((ImageView) this.findViewById(R.id.front_image))
				.setOnTouchListener(new OnTouchListener() {

					@Override
					public boolean onTouch(View v, MotionEvent event) {
						if (event.getAction() == MotionEvent.ACTION_UP) {
							/*AnimationFactory.flipTransition(viewAnimator,
									FlipDirection.LEFT_RIGHT);*/
							AnimationFactory.flipTransition(viewAnimator,
									FlipDirection.LEFT_RIGHT);
							//AnimationFactory.fadeIn( Flip3DViewTransitionActivity.this.findViewById(R.id.back));
							Toast.makeText(Flip3DViewTransitionActivity.this,
									"Side A Touched", Toast.LENGTH_SHORT)
									.show();
						}
						return false;
					}
				});
		/*
		 * this.findViewById(R.id.imageView1).setOnClickListener(new
		 * OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * // This is all you need to do to 3D flip
		 * AnimationFactory.flipTransition(viewAnimator,
		 * FlipDirection.LEFT_RIGHT);
		 * Toast.makeText(Flip3DViewTransitionActivity.this, "Side A Touched",
		 * Toast.LENGTH_SHORT).show(); } });
		 */
		((WebView) this.findViewById(R.id.back))
				.setOnTouchListener(new OnTouchListener() {

					@Override
					public boolean onTouch(View v, MotionEvent event) {
						if (event.getAction() == MotionEvent.ACTION_UP) {
							/*AnimationFactory.flipTransition(viewAnimator,
									FlipDirection.LEFT_RIGHT);*/
							AnimationFactory.flipTransition(viewAnimator,
									FlipDirection.LEFT_RIGHT);
							//AnimationFactory.fadeIn( Flip3DViewTransitionActivity.this.findViewById(R.id.front));
							Toast.makeText(Flip3DViewTransitionActivity.this,
									"Side B Touched", Toast.LENGTH_SHORT)
									.show();
						}
						return false;
					}
				});
		/*
		 * this.findViewById(R.id.imageView2).setOnClickListener( new
		 * OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * // This is all you need to do to 3D flip
		 * AnimationFactory.flipTransition(viewAnimator,
		 * FlipDirection.RIGHT_LEFT);
		 * Toast.makeText(Flip3DViewTransitionActivity.this, "Side B Touched",
		 * Toast.LENGTH_SHORT).show(); } });
		 */}
}