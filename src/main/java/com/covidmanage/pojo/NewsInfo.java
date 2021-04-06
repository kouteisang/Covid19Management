package com.covidmanage.pojo;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

@Builder
public class NewsInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news_info.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news_info.news_title
     *
     * @mbg.generated
     */
    private String newsTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news_info.update_time
     *
     * @mbg.generated
     */
    private String updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news_info.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news_info.news_content
     *
     * @mbg.generated
     */
    private String newsContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table news_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news_info.id
     *
     * @return the value of news_info.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news_info.id
     *
     * @param id the value for news_info.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news_info.news_title
     *
     * @return the value of news_info.news_title
     *
     * @mbg.generated
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news_info.news_title
     *
     * @param newsTitle the value for news_info.news_title
     *
     * @mbg.generated
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news_info.update_time
     *
     * @return the value of news_info.update_time
     *
     * @mbg.generated
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news_info.update_time
     *
     * @param updateTime the value for news_info.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news_info.create_time
     *
     * @return the value of news_info.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news_info.create_time
     *
     * @param createTime the value for news_info.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news_info.news_content
     *
     * @return the value of news_info.news_content
     *
     * @mbg.generated
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news_info.news_content
     *
     * @param newsContent the value for news_info.news_content
     *
     * @mbg.generated
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_info
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", newsContent=").append(newsContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}