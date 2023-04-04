/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;



/**
 *
 * @author mr.quyen
 */
public class ChatLieuViewModel {

    private Integer maChatLieu;
    private String tenChatLieu;

    public ChatLieuViewModel() {
    }

    public ChatLieuViewModel(Integer maChatLieu, String tenChatLieu) {
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
    }

    public Integer getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(Integer maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    @Override
    public String toString() {
        return "ChatLieu{" + "maChatLieu=" + maChatLieu + ", tenChatLieu=" + tenChatLieu + '}';
    }

}
