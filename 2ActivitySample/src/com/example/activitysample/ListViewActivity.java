package com.example.activitysample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends Activity
{
	/**
	 * ListView‚É•\Ž¦‚·‚é—v‘f‚ÌƒNƒ‰ƒX
	 */
	private class ListViewItem
	{
		private int resourceID;
		private String fileName;
		private Bitmap img;

		/**
		 * ƒRƒ“ƒXƒgƒ‰ƒNƒ^
		 * @param resource_id ‰æ‘œƒtƒ@ƒCƒ‹‚ÌƒŠƒ\[ƒXID’l
		 * @param file_name ‰æ‘œƒtƒ@ƒCƒ‹‚Ìƒtƒ@ƒCƒ‹–¼
		 * @param img ‰æ‘œƒtƒ@ƒCƒ‹‚ð•ÏŠ·‚µ‚Äì¬‚µ‚½ƒrƒbƒgƒ}ƒbƒv
		 */
		public ListViewItem(int resource_id, String file_name, Bitmap img)
		{
			this.resourceID = resource_id;
			this.fileName = file_name;
			this.img = img;
		}

		// Getter
		public int getResourceID() { return resourceID; }
		public String getFileName() { return fileName; }
		public Bitmap getImage() { return img; }
	}

	/**
	 * ListView‚ÉƒZƒbƒg‚·‚éƒAƒ_ƒvƒ^‚ÌƒNƒ‰ƒX
	 */
	private class ListViewItemAdapter extends ArrayAdapter<ListViewItem>
	{
		private LayoutInflater layoutInflater;

		/**
		 * ƒRƒ“ƒXƒgƒ‰ƒNƒ^
		 */
		public ListViewItemAdapter(Context context, int textViewResourceId,
				List<ListViewItem> objects)
		{
			// ƒX[ƒp[ƒNƒ‰ƒX‚ÌƒRƒ“ƒXƒgƒ‰ƒNƒ^‚ðŒÄ‚Ño‚·
			super(context, textViewResourceId, objects);

			// LayoutInflater‚ðŽæ“¾‚·‚é
			layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
		}

		/**
		 * ListView‚ÌŠes‚ª•\Ž¦‚·‚é—v‘f‚ð•Ô‚·ƒƒ\ƒbƒh
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			// convertView‚ªnull‚¾‚Á‚½ê‡‚Ì‚ÝALayoutInflater‚ð—˜—p‚µ‚ÄA"listview_item.xml"‚©‚çƒrƒ…[‚ðŽæ“¾‚·‚é
			if(convertView == null)
			{
				convertView = layoutInflater.inflate(R.layout.listview_item, null);
			}

			// positions–Ú‚Ìƒf[ƒ^‚ðŽæ“¾‚·‚é
			ListViewItem item = (ListViewItem)getItem(position);

			// ImageView‚É‰æ‘œ‚ðƒZƒbƒg‚·‚é
			ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView_Item);
			imageView.setImageBitmap( item.getImage() );

			// TextView‚É•¶Žš—ñ‚ðƒZƒbƒg‚·‚é
			TextView textView = (TextView)convertView.findViewById(R.id.textView_Item);
			textView.setText( item.getFileName() );

			// convertView‚ð•Ô‚·
			return convertView;
		}
	}

	/**
	 * ƒAƒNƒeƒBƒrƒeƒBì¬Žž‚ÉŒÄ‚Ño‚³‚ê‚éƒƒ\ƒbƒh
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// ƒX[ƒp[ƒNƒ‰ƒX‚ÌonCreate‚ðŒÄ‚Ño‚·
		super.onCreate(savedInstanceState);

		// ƒRƒ“ƒeƒ“ƒgƒrƒ…[‚É"listview.xml"‚ðƒZƒbƒg‚·‚é
		setContentView(R.layout.listview);

		// ListView‚É•\Ž¦‚·‚é—v‘f‚ðì¬‚·‚é
		List<ListViewItem> list = new ArrayList<ListViewItem>();
		list.add( new ListViewItem(
				R.drawable.droid, "droid.jpeg",
				BitmapFactory.decodeResource(getResources(), R.drawable.droid) ));
		list.add( new ListViewItem(
				R.drawable.images, "images.jpeg",
				BitmapFactory.decodeResource(getResources(), R.drawable.images) ));
		list.add( new ListViewItem(
				R.drawable.yarimizu, "yarimizu.jpg",
				BitmapFactory.decodeResource(getResources(), R.drawable.yarimizu) ));

		// ƒAƒ_ƒvƒ^‚ÉƒŠƒXƒg‚ðƒZƒbƒg‚·‚é
		ListViewItemAdapter adapter = new ListViewItemAdapter(this, 0, list);

		// ListView‚ðŽæ“¾‚·‚é
		ListView listView = (ListView)findViewById(R.id.listView);

		// ListView‚ÉƒAƒ_ƒvƒ^‚ðƒZƒbƒg‚·‚é
		listView.setAdapter(adapter);

		// ListView‚Ì—v‘f‚ªƒ^ƒbƒ`‚³‚ê‚½Žž‚ÉŒÄ‚Ño‚³‚ê‚éƒCƒxƒ“ƒgƒŠƒXƒi[‚Æ‚µ‚Ä–³–¼ƒNƒ‰ƒX‚ðƒZƒbƒg‚·‚é
		listView.setOnItemClickListener( new AdapterView.OnItemClickListener()
		{
			// —v‘f‚ðƒ^ƒbƒ`‚µ‚½Žž‚ÉŒÄ‚Ño‚³‚ê‚éƒƒ\ƒbƒh
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// ‘I‘ð‚µ‚½—v‘f‚ðŽæ“¾‚·‚é
				ListView listView = (ListView)parent;
				ListViewItem item = (ListViewItem)listView.getItemAtPosition(position);

				// ImageViewActivity‚É‘JˆÚ‚·‚é‚½‚ß‚ÌƒCƒ“ƒeƒ“ƒg‚ðì¬‚·‚é
				Intent intent = new Intent(ListViewActivity.this, ImageViewActivity.class);

				// ƒCƒ“ƒeƒ“ƒg‚ÉA‘I‘ð‚µ‚½—v‘f‚ÌresourceID’l‚ðƒZƒbƒg‚·‚é
				intent.putExtra( "resourceID", item.getResourceID() );

				// ImageViewActivity‚Ö‚Æ‘JˆÚ‚·‚é
				startActivity(intent);
			}
		} );
	}
}