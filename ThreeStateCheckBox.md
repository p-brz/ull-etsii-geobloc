# Introduction #

This is new widget was built as a compound widget, from a ThreeStateButton and a TextView. The main idea was to keep it as similar to a standard Android Framework CheckBox, but offering the functionality the three states functionality.


# Details #

The ThreeStateCheckBox has three possible states:

```
// nothing
public static final int __STATE_UNPRESSED__ = 0;
// red cross
public static int __STATE_PRESSED__ = 1;
// green tick
public static int __STATE_CHECKED__ = 2;
```

And using it in our app is very easy. Here's a sample code for inflating it through XML:

```
<LinearLayout
  	xmlns:android="http://schemas.android.com/apk/res/android"
  	xmlns:app="http://schemas.android.com/apk/res/com.geobloc"
  	android:layout_width="wrap_content"
  	android:layout_height="wrap_content"
  	android:orientation="horizontal">
	<com.geobloc.widget.ThreeStateCheckBox
  		android:layout_width="wrap_content"
  		android:layout_height="wrap_content"
  		app:label="I am a ThreeStateCheckBox"
  		app:shadow="true"
  		app:state="2">
  	</com.geobloc.widget.ThreeStateCheckBox>
</LinearLayout>
```

As you can see, we must first declare the app property to access our widget's own properties, since these are not properties provided by the Android Framework. The label property defines the text of the ThreeStateCheckBox, the shadow property allows the developer to enable/disable a background shadow of the cross and tick on the button (similar to the tick shadow in the standard CheckBox) and finally, state allows the developer to specify the inital state of the ThreeStateCheckBox.

The ThreeStateCheckBox can also be instanced programmatically. We had some trouble finding the way to make it work, so try to stick to this code while creating your new ThreeStateCheckBox, or its behaviour won't be the one you expect.

```
// ViewGroup where we want to add our ThreeStateCheckBox
LinearLayout myLinearLayout = (LinearLayout) findViewById(R.id.myLinearLayout);
// It's very important to use this constructor (otherwise the view won't inflate) and
// to set the layout parameters, or it won't behave correctly with multi-line texts
ThreeStateCheckBox threestate = new ThreeStateCheckBox(this);
threestate.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
			ViewGroup.LayoutParams.WRAP_CONTENT));
// from now onwards, the view will behave ok
threestate.setState(ThreeStateButton.__STATE_PRESSED__);
threestate.setText("Programmatically inflated ThreeStateCheckBox.");
threestate.setDrawShadowEnabled(true);
// note that we can change the state, the text and the shadow after adding the view to 
// its container
myLinearLayout.addView(threestate);
```

You can get and set the label (TextView) next to the ThreeStateButton using the following methods:

```
public TextView getLabel();
public void setLabel(TextView label);
```

# Dependencies #

To use this widget, you'll need the following files:

```
/res/layout/three_state_checkbox.xml
/res/values/attrs.xml
com.geobloc.widget.ThreeStateButton;
com.geobloc.widget.ThreeStateCheckBox;
```

# Contact #

For any issues/recommendations using this widget, please contact goldrunner192287@gmail.com