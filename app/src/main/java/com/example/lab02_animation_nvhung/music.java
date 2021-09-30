package com.example.lab02_animation_nvhung;

public class music {
    private int img;
    private String musicName;
    private String authorName;

    public music() {
    }

    public music(int img, String musicName, String authorName) {
        this.img = img;
        this.musicName = musicName;
        this.authorName = authorName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
