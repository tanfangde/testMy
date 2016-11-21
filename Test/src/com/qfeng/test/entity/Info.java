package com.qfeng.test.entity;
/**
 * "id":"8289",
            "title":"油焖大虾",
            "pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/9/8289.jpg",
            "collect_num":"1580",
            "food_str":"大虾 葱 生姜 植物油 料酒",
            "num":1580
 * @author Administrator
 *
 */
public class Info {
	private String title;
	private String pic;
	private String food_str;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getFood_str() {
		return food_str;
	}
	public void setFood_str(String food_str) {
		this.food_str = food_str;
	}
	
	@Override
	public String toString() {
		return "Info [title=" + title + ", pic=" + pic + ", food_str="
				+ food_str + "]";
	}
}
