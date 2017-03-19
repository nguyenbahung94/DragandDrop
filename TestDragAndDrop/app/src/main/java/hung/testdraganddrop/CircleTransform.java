package hung.testdraganddrop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by Adam on 3/19/2017.
 */

public class CircleTransform extends BitmapTransformation {
    public CircleTransform(Context context) {
        super(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool, toTransform);
    }

    @Override
    public String getId() {
        return getClass().getName();
    }
    public  static Bitmap circleCrop(BitmapPool pool,Bitmap source){
        if (source==null) return null;
        int size=Math.min(source.getWidth(),source.getHeight());
        int x=(source.getWidth()-size);
        int y=(source.getHeight()-size);
        Bitmap squared=Bitmap.createBitmap(source,x,y,size,size);
        Bitmap result=pool.get(size,size,Bitmap.Config.ARGB_8888);
        if (result == null) {
            result=Bitmap.createBitmap(size,size,Bitmap.Config.ARGB_8888);
        }
        Canvas canvas =new Canvas(result);
        Paint paint=new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);
        return result;
    }
}
