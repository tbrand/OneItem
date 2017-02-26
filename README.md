
## OneItem

Simple implementation for one item selected RecyclerView.
This makes it easier to use arbitrary VideoView (such as MediaPlayer) in RecyclerView.
This library includes RecyclerView.LayoutManager and Recyclerview.OnScrollListener.

You can realize auto-playing Video View like Facebook, Instagram, Twitter or other famous single column SNS by this library.

## Sample

## Usage

### Install

In your top level `build.gradle`, add
```
allprojects {
    repositories {
		...
        maven { url  "http://tbrandlib.bintray.com/maven" }
    }
}
```

In your application level `build.gradle`, add
```
dependencies {
	compile 'com.tbrandlib.oneitem:oneitem:0.1.0'
}
```

### In java code

Implement `OneItemListener` in you RecyclerView.Adapter.
```java
MainAdapter extends RecyclerView.Adapter implements OneItemListener{

	/// This method is called when the item at the position is selected as the one item
    @Override
    public void selectItemAt(int position) {
	
    }

    // This method is called when the item at the position is unselected
    @Override
    public void unSelectItemAt(int position) {
	
    }
}
```

Setup OneItem with your RecyclerView.
```java
//MainAdapter implements OneItemListener
MainAdapter adapter = new MainAdapter(this);

RecyclerView recyclerView = (RecyclerView)findViewById(R.id.main_recycler_view);
recyclerView.setAdapter(adapter);

//You can setup one item manager like this
OneItemManager.setup(this, adapter, recyclerView);
```

Now you can get callback from OneItem to `#selectItemAt` and `#unSelectItemAt`.
