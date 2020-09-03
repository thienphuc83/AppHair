package com.example.hair.server;

import com.example.hair.model.KhachHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("getallkhachhang.php")
    Call<List<KhachHang>> GetAllKH();
//
//    @GET("playlistforcurrentday.php")
//    Call<List<PlayList>> GetPlaylistCurrentDay();
//
//    @GET("chudevatheloaitrongngay.php")
//    Call<TheLoaiTrongNgay> GetChuDeTheLoaiTrongNgay();
//
//    @GET("album.php")
//    Call<List<Album>> GetAlbumHot();
//
//    @GET("baihatyeuthich.php")
//    Call<List<BaiHat>> GetBaiHatHot();
//
//    @FormUrlEncoded
//    @POST("danhsachbaihat.php")
//    Call<List<BaiHat>> GetDanhSachBaiHatTheoQuangCao(@Field("idquangcao") String idquangcao);
//
//    @FormUrlEncoded
//    @POST("danhsachbaihat.php")
//    Call<List<BaiHat>> GetDanhSachBaiHatTheoPlayList(@Field("idplaylist") String idplaylist);
//
//    @GET("danhsachplaylist.php")
//    Call<List<PlayList>> GetDanhSachPlayList();
//
//    @FormUrlEncoded
//    @POST("danhsachbaihat.php")
//    Call<List<BaiHat>> GetDanhSachBaiHatTheoTheLoai(@Field("idtheloai") String idtheloai);
//
//    @GET("allchude.php")
//    Call<List<ChuDe>> GetDanhSachChuDe();
//
//    @FormUrlEncoded
//    @POST("theloaitheochude.php")
//    Call<List<TheLoai>> GetDanhSachTheLoaiTheoChuDe(@Field("idchude") String idchude);
//
//    @GET("allalbum.php")
//    Call<List<Album>> GetDanhSachAllAlbum();
//
//    @FormUrlEncoded
//    @POST("danhsachbaihat.php")
//    Call<List<BaiHat>> GetDanhSachBaiHatTheoAlbum(@Field("idalbum") String idalbum);
//
//    @FormUrlEncoded
//    @POST("updateluotthich.php")
//    Call<String> UpdateLuotThichBaiHat(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);
//
//    @FormUrlEncoded
//    @POST("searchbaihat.php")
//    Call<List<BaiHat>> ReSearchBaiHat(@Field("tukhoa") String tukhoa);
}
