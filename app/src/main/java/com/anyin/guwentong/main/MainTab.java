package com.anyin.guwentong.main;


import com.anyin.guwentong.R;

public enum MainTab {

	HOME(0, R.string.main_tab_home, R.drawable.selector_mine_home,
			HomeFragment.class),


 	SHOPING(1, R.string.main_tab_shop, R.drawable.selector_mine_shop,
 			ShopFragment.class),



	MY(2, R.string.main_tab_my, R.drawable.selector_mine_my, MyFragment.class),

	MORE(3, R.string.main_tab_more, R.drawable.selector_mine_more,
		  MoreFragment.class);

	private int idx;
	private int resName;
	private int resIcon;
	private Class<?> clz;

	private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
		this.idx = idx;
		this.resName = resName;
		this.resIcon = resIcon;
		this.clz = clz;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Class<?> getClz() {
		return clz;
	}

	public void setClz(Class<?> clz) {
		this.clz = clz;
	}
}
