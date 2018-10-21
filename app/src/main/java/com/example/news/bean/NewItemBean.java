package com.example.news.bean;

import java.util.List;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/10/21 0021 23:09
 */

public class NewItemBean {

    /**
     * data : {"countcommenturl":"http://zhbj.qianlong.com/client/content/countComment/","more":"/10007/list_2.json","news":[{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35311,"listimage":"http://192.168.1.101:8080/zhbj/10007/20160218142345afea9.jpg","pubdate":"2016-02-18 14:22:04","title":"丰台区奥迪撞上双层公交车 一人身亡","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG4527D000964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35312,"listimage":"http://192.168.1.101:8080/zhbj/10007/2016021814082438940.jpg","pubdate":"2016-02-18 14:07:25","title":"清明离京热门方向普通列车有座票基本售罄","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG447CDE00964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35313,"listimage":"http://192.168.1.101:8080/zhbj/10007/2016021813490523470.jpg","pubdate":"2016-02-18 07:55:00","title":"评论|北京一日游黑市沉疴凸显监管缺位","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3K9RKE00964LDC.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35314,"listimage":"http://192.168.1.101:8080/zhbj/10007/6598296821693127421.jpg","pubdate":"2016-02-18 11:07:40","title":"急救直升机备降点今年有望扩容 提高999服务水平","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3TIRH300964M8H.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://192.168.1.101:8080/zhbj/10007/20160216103738323b5.jpg","pubdate":"2016-02-16 09:48:45","title":"北京·城事：北漂青年的相亲经历","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BFUGKA5N00964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://192.168.1.101:8080/zhbj/10007/7916883942222950177.jpg","pubdate":"2016-02-18 10:08:28","title":"阎肃追悼会举行:群众落泪悼念 有人当场晕倒","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3PMN5J00964LDC.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://192.168.1.101:8080/zhbj/10007/20160218111151174f4.jpg","pubdate":"2016-02-18 11:10:19","title":"男子强拍女友不雅照 分手后发其朋友圈出言侮辱","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3Q33UB00964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://192.168.1.101:8080/zhbj/10007/6631332748006456772.jpg","pubdate":"2016-02-18 09:45:37","title":"记者回访三家医院发现号贩子已无踪影","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3O7U5U00964M8H.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35316,"listimage":"http://192.168.1.101:8080/zhbj/10007/20160218102329de038.jpg","pubdate":"2016-02-18 10:22:00","title":"趁孩子母亲上厕所抱走男童 90后男子涉拐骗儿童被诉","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3NAKH900964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35317,"listimage":"http://192.168.1.101:8080/zhbj/10007/2016021810395430868.jpg","pubdate":"2016-02-18 10:22:00","title":"猴宝预计30万 今后大医院将主要收治高危孕产妇","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3OA16A00964J4O.html"}],"title":"北京","topic":[],"topnews":[{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35301,"pubdate":"2016-02-18 01:43:28","title":"男童截小腿后感染再截大腿起诉医院","topimage":"http://192.168.1.101:8080/zhbj/10007/20160218044034a8788.jpg","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG2PL5P000014AED.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35302,"pubdate":"2016-02-18 10:23:18","title":"北京副市长林克庆任北京红十字会会长","topimage":"http://192.168.1.101:8080/zhbj/10007/20160218103117f44f1.jpg","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3ND15J00963VRO.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35303,"pubdate":"2016-02-18 08:54:59","title":"本市今日最高气温9℃ 阵风可达六级","topimage":"http://192.168.1.101:8080/zhbj/10007/201602180857016b62f.jpg","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3IB9E000964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35304,"pubdate":"2016-02-18 08:09:00","title":"北京昌平、平谷、延庆三区入选国家全域旅游示范区","topimage":"http://192.168.1.101:8080/zhbj/10007/20160218134750e5d1a.jpg","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3PMQOK00964LDC.html"}]}
     * retcode : 200
     */

    private DataBean data;
    private int retcode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public static class DataBean {
        /**
         * countcommenturl : http://zhbj.qianlong.com/client/content/countComment/
         * more : /10007/list_2.json
         * news : [{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35311,"listimage":"http://192.168.1.101:8080/zhbj/10007/20160218142345afea9.jpg","pubdate":"2016-02-18 14:22:04","title":"丰台区奥迪撞上双层公交车 一人身亡","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG4527D000964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35312,"listimage":"http://192.168.1.101:8080/zhbj/10007/2016021814082438940.jpg","pubdate":"2016-02-18 14:07:25","title":"清明离京热门方向普通列车有座票基本售罄","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG447CDE00964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35313,"listimage":"http://192.168.1.101:8080/zhbj/10007/2016021813490523470.jpg","pubdate":"2016-02-18 07:55:00","title":"评论|北京一日游黑市沉疴凸显监管缺位","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3K9RKE00964LDC.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35314,"listimage":"http://192.168.1.101:8080/zhbj/10007/6598296821693127421.jpg","pubdate":"2016-02-18 11:07:40","title":"急救直升机备降点今年有望扩容 提高999服务水平","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3TIRH300964M8H.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://192.168.1.101:8080/zhbj/10007/20160216103738323b5.jpg","pubdate":"2016-02-16 09:48:45","title":"北京·城事：北漂青年的相亲经历","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BFUGKA5N00964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://192.168.1.101:8080/zhbj/10007/7916883942222950177.jpg","pubdate":"2016-02-18 10:08:28","title":"阎肃追悼会举行:群众落泪悼念 有人当场晕倒","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3PMN5J00964LDC.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://192.168.1.101:8080/zhbj/10007/20160218111151174f4.jpg","pubdate":"2016-02-18 11:10:19","title":"男子强拍女友不雅照 分手后发其朋友圈出言侮辱","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3Q33UB00964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://192.168.1.101:8080/zhbj/10007/6631332748006456772.jpg","pubdate":"2016-02-18 09:45:37","title":"记者回访三家医院发现号贩子已无踪影","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3O7U5U00964M8H.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35316,"listimage":"http://192.168.1.101:8080/zhbj/10007/20160218102329de038.jpg","pubdate":"2016-02-18 10:22:00","title":"趁孩子母亲上厕所抱走男童 90后男子涉拐骗儿童被诉","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3NAKH900964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35317,"listimage":"http://192.168.1.101:8080/zhbj/10007/2016021810395430868.jpg","pubdate":"2016-02-18 10:22:00","title":"猴宝预计30万 今后大医院将主要收治高危孕产妇","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3OA16A00964J4O.html"}]
         * title : 北京
         * topic : []
         * topnews : [{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35301,"pubdate":"2016-02-18 01:43:28","title":"男童截小腿后感染再截大腿起诉医院","topimage":"http://192.168.1.101:8080/zhbj/10007/20160218044034a8788.jpg","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG2PL5P000014AED.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35302,"pubdate":"2016-02-18 10:23:18","title":"北京副市长林克庆任北京红十字会会长","topimage":"http://192.168.1.101:8080/zhbj/10007/20160218103117f44f1.jpg","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3ND15J00963VRO.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35303,"pubdate":"2016-02-18 08:54:59","title":"本市今日最高气温9℃ 阵风可达六级","topimage":"http://192.168.1.101:8080/zhbj/10007/201602180857016b62f.jpg","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3IB9E000964J4O.html"},{"comment":true,"commentlist":"http://192.168.1.101:8080/zhbj/10007/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35304,"pubdate":"2016-02-18 08:09:00","title":"北京昌平、平谷、延庆三区入选国家全域旅游示范区","topimage":"http://192.168.1.101:8080/zhbj/10007/20160218134750e5d1a.jpg","type":"news","url":"http://192.168.1.101:8080/zhbj/10007/BG3PMQOK00964LDC.html"}]
         */

        private String countcommenturl;
        private String more;
        private String title;
        private List<NewsBean> news;
        private List<?> topic;
        private List<TopnewsBean> topnews;

        public String getCountcommenturl() {
            return countcommenturl;
        }

        public void setCountcommenturl(String countcommenturl) {
            this.countcommenturl = countcommenturl;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<?> getTopic() {
            return topic;
        }

        public void setTopic(List<?> topic) {
            this.topic = topic;
        }

        public List<TopnewsBean> getTopnews() {
            return topnews;
        }

        public void setTopnews(List<TopnewsBean> topnews) {
            this.topnews = topnews;
        }

        public static class NewsBean {
            /**
             * comment : true
             * commentlist : http://192.168.1.101:8080/zhbj/10007/comment_1.json
             * commenturl : http://zhbj.qianlong.com/client/user/newComment/35319
             * id : 35311
             * listimage : http://192.168.1.101:8080/zhbj/10007/20160218142345afea9.jpg
             * pubdate : 2016-02-18 14:22:04
             * title : 丰台区奥迪撞上双层公交车 一人身亡
             * type : news
             * url : http://192.168.1.101:8080/zhbj/10007/BG4527D000964J4O.html
             */

            private boolean comment;
            private String commentlist;
            private String commenturl;
            private int id;
            private String listimage;
            private String pubdate;
            private String title;
            private String type;
            private String url;

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public String getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
            }

            public String getCommenturl() {
                return commenturl;
            }

            public void setCommenturl(String commenturl) {
                this.commenturl = commenturl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getListimage() {
                return listimage;
            }

            public void setListimage(String listimage) {
                this.listimage = listimage;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TopnewsBean {
            /**
             * comment : true
             * commentlist : http://192.168.1.101:8080/zhbj/10007/comment_1.json
             * commenturl : http://zhbj.qianlong.com/client/user/newComment/35301
             * id : 35301
             * pubdate : 2016-02-18 01:43:28
             * title : 男童截小腿后感染再截大腿起诉医院
             * topimage : http://192.168.1.101:8080/zhbj/10007/20160218044034a8788.jpg
             * type : news
             * url : http://192.168.1.101:8080/zhbj/10007/BG2PL5P000014AED.html
             */

            private boolean comment;
            private String commentlist;
            private String commenturl;
            private int id;
            private String pubdate;
            private String title;
            private String topimage;
            private String type;
            private String url;

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public String getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
            }

            public String getCommenturl() {
                return commenturl;
            }

            public void setCommenturl(String commenturl) {
                this.commenturl = commenturl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTopimage() {
                return topimage;
            }

            public void setTopimage(String topimage) {
                this.topimage = topimage;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
