package me.huqiao.smallcms.util;

import me.huqiao.smallcms.common.entity.CommonFolder;

public class ThumbInfo {

	private int width;
	private int height;
	private float quality;
	private String extensionName;
	private CommonFolder folder;
	private String name;
	
	public ThumbInfo(int width, int height, float quality,String extensionName,CommonFolder folder,String name) {
		this.width = width;
		this.height = height;
		this.quality = quality;
		this.extensionName = extensionName;
		this.folder = folder;
		this.name = name;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public float getQuality() {
		return quality;
	}
	public void setQuality(float quality) {
		this.quality = quality;
	}

	public String getExtensionName() {
		return extensionName;
	}
	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}

	public CommonFolder getFolder() {
		return folder;
	}

	public void setFolder(CommonFolder folder) {
		this.folder = folder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
