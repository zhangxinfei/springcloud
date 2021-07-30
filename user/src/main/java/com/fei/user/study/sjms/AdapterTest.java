package com.fei.user.study.sjms;

/**
 * @author: zhangxinfei
 * create at:  2021/5/21  3:33 下午
 * @description: 适配器模式
 */
public class AdapterTest {



}

/**
 * 播放器---适配器实例
 */
interface MediaPlayer{
    public void play(String audioType, String fileName);
}

/**
 *
 */
interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}