/*
 * Catroid: An on-device visual programming system for Android devices
 * Copyright (C) 2010-2015 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.catroid.livewallpaper.ui;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import org.catrobat.catroid.R;


/**
 * Created by marco on 18.03.15.
 */
public class SelectProgramActivity extends BaseActivity  {

	public static final String ACTION_PROJECT_LIST_INIT = "org.catrobat.catroid.livewallpaper.PROJECT_LIST_INIT";

	private SelectProgramFragment selectProgramFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_projects_lwp);
		setUpActionBar();

		selectProgramFragment = (SelectProgramFragment) getSupportFragmentManager().findFragmentById(
				R.id.fragment_projects_list_lwp);
	}

	@Override
	public void onResume(){
		super.onResume();
		/*
		if(LiveWallpaper.getInstance() == null){
			startMainMenu();
		}*/
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			sendBroadcast(new Intent(ACTION_PROJECT_LIST_INIT));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.menu_selectprogram_lwp, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.lwp_delete: {
				selectProgramFragment.startDeleteActionMode();
				Log.d("LWP|SelectProgramAct", "Options: delete clicked!");
				break;
			}
			case R.id.lwp_about: {
				/*AboutPocketCodeDialog aboutPocketCodeDialog = new AboutPocketCodeDialog(this);
				aboutPocketCodeDialog.show();*/
				Log.d("LWP|SelectProgramAct", "Options: about clicked!");
				break;
			}
			case R.id.lwp_pocket_code: {
				//startMainMenu();
				Log.d("LWP|SelectProgramAct", "Options: pocket_code clicked!");
				break;
			}
		}
		return super.onOptionsItemSelected(item);
	}

	private void setUpActionBar() {
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(R.string.lwp_select_program);
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setHomeButtonEnabled(false);
	}

	public SelectProgramFragment getSelectProgramFragment() {
		return selectProgramFragment;
	}

}