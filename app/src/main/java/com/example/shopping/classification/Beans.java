package com.example.shopping.classification;

import java.io.Serializable;
import java.util.List;

public class Beans implements Serializable{

    /**
     * status : 0
     * message : 列表获取成功
     * data : [{"id":12,"categoryId":15,"goodsDesc":"联想（ThinkPad）E460（20ETA063CD）14英寸笔记本电脑（i7-6498DU 8G 1T 2G独显 Win10）","goodsDefaultIcon":"https://img14.360buyimg.com/n1/s450x450_jfs/t5446/184/2581563799/286954/9ebfad09/591bddbcNc724d048.jpg","goodsDefaultPrice":"100","goodsDetailOne":"https://img20.360buyimg.com/vc/jfs/t5563/279/850602969/1094377/272f0258/5907fc23N3a312831.jpg","goodsDetailTwo":"https://img20.360buyimg.com/vc/jfs/t5563/279/850602969/1094377/272f0258/5907fc23N3a312831.jpg","goodsSalesCount":56667,"goodsStockCount":8434,"goodsCode":"10000000015","goodsDefaultSku":"【i7豪华版】8G 1T,1件","maxPage":1},{"id":13,"categoryId":15,"goodsDesc":"ThinkPad New S2（20GU0000CD）13.3英寸轻薄笔记本电脑（i5-6200U 4G 240GB SSD FHD IPS Win10 银色）","goodsDefaultIcon":"https://img12.360buyimg.com/n1/s450x450_jfs/t3439/192/665209614/82997/ce6c3ad8/58107973Na856a8e1.jpg","goodsDefaultPrice":"200","goodsDetailOne":"https://img20.360buyimg.com/vc/jfs/t3172/316/316003976/446142/2e681194/57b168fcNfc72b6c2.jpg","goodsDetailTwo":"https://img20.360buyimg.com/vc/jfs/t3172/316/316003976/446142/2e681194/57b168fcNfc72b6c2.jpg","goodsSalesCount":53453,"goodsStockCount":5623,"goodsCode":"10000000016","goodsDefaultSku":"【轻薄特价】180打开i5标配,1件","maxPage":1},{"id":14,"categoryId":15,"goodsDesc":"联想（ThinkPad）黑侠E570 GTX（1NCD）游戏笔记本（i5-7200U 4G 500G+128G SSD GTX950M 2G独显 FHD Win10）","goodsDefaultIcon":"https://img13.360buyimg.com/n1/s450x450_jfs/t3589/5/1216566713/222593/43da0a93/5822ed83N8f0984b9.jpg","goodsDefaultPrice":"300","goodsDetailOne":"https://img20.360buyimg.com/vc/jfs/t3850/230/1078650780/1998827/c8083d77/5822d122N3d828e6d.jpg","goodsDetailTwo":"https://img20.360buyimg.com/vc/jfs/t3850/230/1078650780/1998827/c8083d77/5822d122N3d828e6d.jpg","goodsSalesCount":32423,"goodsStockCount":7345,"goodsCode":"10000000017","goodsDefaultSku":"【黑侠游戏本特价款】GTX950,1件","maxPage":1},{"id":15,"categoryId":15,"goodsDesc":"ThinkPad X1 Carbon 2017（20HRA007CD）14英寸轻薄笔记本电脑（i5-7200U 8G 256GSSD FHD Win10）","goodsDefaultIcon":"https://img11.360buyimg.com/n1/s450x450_jfs/t4804/97/1759098535/205293/61ec47d0/58f428f6N5b35ea21.jpg","goodsDefaultPrice":"300","goodsDetailOne":"https://img20.360buyimg.com/vc/jfs/t3850/230/1078650780/1998827/c8083d77/5822d122N3d828e6d.jpg","goodsDetailTwo":"https://img20.360buyimg.com/vc/jfs/t3850/230/1078650780/1998827/c8083d77/5822d122N3d828e6d.jpg","goodsSalesCount":9894,"goodsStockCount":10000,"goodsCode":"10000000018","goodsDefaultSku":"2017新X1 8G 256G,1件","maxPage":1}]
     */

    private List<DataBean> data;



    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


    public static class DataBean implements Serializable {
        /**
         * id : 12
         * categoryId : 15
         * goodsDesc : 联想（ThinkPad）E460（20ETA063CD）14英寸笔记本电脑（i7-6498DU 8G 1T 2G独显 Win10）
         * goodsDefaultIcon : https://img14.360buyimg.com/n1/s450x450_jfs/t5446/184/2581563799/286954/9ebfad09/591bddbcNc724d048.jpg
         * goodsDefaultPrice : 100
         * goodsDetailOne : https://img20.360buyimg.com/vc/jfs/t5563/279/850602969/1094377/272f0258/5907fc23N3a312831.jpg
         * goodsDetailTwo : https://img20.360buyimg.com/vc/jfs/t5563/279/850602969/1094377/272f0258/5907fc23N3a312831.jpg
         * goodsSalesCount : 56667
         * goodsStockCount : 8434
         * goodsCode : 10000000015
         * goodsDefaultSku : 【i7豪华版】8G 1T,1件
         * maxPage : 1
         */

        private int id;
        private int categoryId;
        private String goodsDesc;
        private String goodsDefaultIcon;
        private String goodsDefaultPrice;
        private String goodsDetailOne;
        private String goodsDetailTwo;
        private int goodsSalesCount;
        private int goodsStockCount;
        private String goodsCode;
        private String goodsDefaultSku;
        private int maxPage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getGoodsDesc() {
            return goodsDesc;
        }

        public void setGoodsDesc(String goodsDesc) {
            this.goodsDesc = goodsDesc;
        }

        public String getGoodsDefaultIcon() {
            return goodsDefaultIcon;
        }

        public void setGoodsDefaultIcon(String goodsDefaultIcon) {
            this.goodsDefaultIcon = goodsDefaultIcon;
        }

        public String getGoodsDefaultPrice() {
            return goodsDefaultPrice;
        }

        public void setGoodsDefaultPrice(String goodsDefaultPrice) {
            this.goodsDefaultPrice = goodsDefaultPrice;
        }

        public String getGoodsDetailOne() {
            return goodsDetailOne;
        }

        public void setGoodsDetailOne(String goodsDetailOne) {
            this.goodsDetailOne = goodsDetailOne;
        }

        public String getGoodsDetailTwo() {
            return goodsDetailTwo;
        }

        public void setGoodsDetailTwo(String goodsDetailTwo) {
            this.goodsDetailTwo = goodsDetailTwo;
        }

        public int getGoodsSalesCount() {
            return goodsSalesCount;
        }

        public void setGoodsSalesCount(int goodsSalesCount) {
            this.goodsSalesCount = goodsSalesCount;
        }

        public int getGoodsStockCount() {
            return goodsStockCount;
        }

        public void setGoodsStockCount(int goodsStockCount) {
            this.goodsStockCount = goodsStockCount;
        }

        public String getGoodsCode() {
            return goodsCode;
        }

        public void setGoodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
        }

        public String getGoodsDefaultSku() {
            return goodsDefaultSku;
        }

        public void setGoodsDefaultSku(String goodsDefaultSku) {
            this.goodsDefaultSku = goodsDefaultSku;
        }

        public int getMaxPage() {
            return maxPage;
        }

        public void setMaxPage(int maxPage) {
            this.maxPage = maxPage;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", categoryId=" + categoryId +
                    ", goodsDesc='" + goodsDesc + '\'' +
                    ", goodsDefaultIcon='" + goodsDefaultIcon + '\'' +
                    ", goodsDefaultPrice='" + goodsDefaultPrice + '\'' +
                    ", goodsDetailOne='" + goodsDetailOne + '\'' +
                    ", goodsDetailTwo='" + goodsDetailTwo + '\'' +
                    ", goodsSalesCount=" + goodsSalesCount +
                    ", goodsStockCount=" + goodsStockCount +
                    ", goodsCode='" + goodsCode + '\'' +
                    ", goodsDefaultSku='" + goodsDefaultSku + '\'' +
                    ", maxPage=" + maxPage +
                    '}';
        }
    }
}
