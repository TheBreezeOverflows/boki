package boke.boke.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BlogsarticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogsarticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBlogsarticleIdIsNull() {
            addCriterion("BlogsArticle_Id is null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdIsNotNull() {
            addCriterion("BlogsArticle_Id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdEqualTo(Integer value) {
            addCriterion("BlogsArticle_Id =", value, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdNotEqualTo(Integer value) {
            addCriterion("BlogsArticle_Id <>", value, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdGreaterThan(Integer value) {
            addCriterion("BlogsArticle_Id >", value, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BlogsArticle_Id >=", value, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdLessThan(Integer value) {
            addCriterion("BlogsArticle_Id <", value, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("BlogsArticle_Id <=", value, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdIn(List<Integer> values) {
            addCriterion("BlogsArticle_Id in", values, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdNotIn(List<Integer> values) {
            addCriterion("BlogsArticle_Id not in", values, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdBetween(Integer value1, Integer value2) {
            addCriterion("BlogsArticle_Id between", value1, value2, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BlogsArticle_Id not between", value1, value2, "blogsarticleId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdIsNull() {
            addCriterion("BlogsArticle_User_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdIsNotNull() {
            addCriterion("BlogsArticle_User_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdEqualTo(Integer value) {
            addCriterion("BlogsArticle_User_id =", value, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdNotEqualTo(Integer value) {
            addCriterion("BlogsArticle_User_id <>", value, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdGreaterThan(Integer value) {
            addCriterion("BlogsArticle_User_id >", value, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BlogsArticle_User_id >=", value, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdLessThan(Integer value) {
            addCriterion("BlogsArticle_User_id <", value, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("BlogsArticle_User_id <=", value, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdIn(List<Integer> values) {
            addCriterion("BlogsArticle_User_id in", values, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdNotIn(List<Integer> values) {
            addCriterion("BlogsArticle_User_id not in", values, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdBetween(Integer value1, Integer value2) {
            addCriterion("BlogsArticle_User_id between", value1, value2, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BlogsArticle_User_id not between", value1, value2, "blogsarticleUserId");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineIsNull() {
            addCriterion("BlogsArticle_Headline is null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineIsNotNull() {
            addCriterion("BlogsArticle_Headline is not null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineEqualTo(String value) {
            addCriterion("BlogsArticle_Headline =", value, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineNotEqualTo(String value) {
            addCriterion("BlogsArticle_Headline <>", value, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineGreaterThan(String value) {
            addCriterion("BlogsArticle_Headline >", value, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_Headline >=", value, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineLessThan(String value) {
            addCriterion("BlogsArticle_Headline <", value, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineLessThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_Headline <=", value, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineLike(String value) {
            addCriterion("BlogsArticle_Headline like", value, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineNotLike(String value) {
            addCriterion("BlogsArticle_Headline not like", value, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineIn(List<String> values) {
            addCriterion("BlogsArticle_Headline in", values, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineNotIn(List<String> values) {
            addCriterion("BlogsArticle_Headline not in", values, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineBetween(String value1, String value2) {
            addCriterion("BlogsArticle_Headline between", value1, value2, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleHeadlineNotBetween(String value1, String value2) {
            addCriterion("BlogsArticle_Headline not between", value1, value2, "blogsarticleHeadline");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateIsNull() {
            addCriterion("BlogsArticle_Date is null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateIsNotNull() {
            addCriterion("BlogsArticle_Date is not null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateEqualTo(Date value) {
            addCriterionForJDBCDate("BlogsArticle_Date =", value, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("BlogsArticle_Date <>", value, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateGreaterThan(Date value) {
            addCriterionForJDBCDate("BlogsArticle_Date >", value, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BlogsArticle_Date >=", value, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateLessThan(Date value) {
            addCriterionForJDBCDate("BlogsArticle_Date <", value, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BlogsArticle_Date <=", value, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateIn(List<Date> values) {
            addCriterionForJDBCDate("BlogsArticle_Date in", values, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("BlogsArticle_Date not in", values, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BlogsArticle_Date between", value1, value2, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BlogsArticle_Date not between", value1, value2, "blogsarticleDate");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageIsNull() {
            addCriterion("BlogsArticle_image is null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageIsNotNull() {
            addCriterion("BlogsArticle_image is not null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageEqualTo(String value) {
            addCriterion("BlogsArticle_image =", value, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageNotEqualTo(String value) {
            addCriterion("BlogsArticle_image <>", value, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageGreaterThan(String value) {
            addCriterion("BlogsArticle_image >", value, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageGreaterThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_image >=", value, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageLessThan(String value) {
            addCriterion("BlogsArticle_image <", value, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageLessThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_image <=", value, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageLike(String value) {
            addCriterion("BlogsArticle_image like", value, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageNotLike(String value) {
            addCriterion("BlogsArticle_image not like", value, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageIn(List<String> values) {
            addCriterion("BlogsArticle_image in", values, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageNotIn(List<String> values) {
            addCriterion("BlogsArticle_image not in", values, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageBetween(String value1, String value2) {
            addCriterion("BlogsArticle_image between", value1, value2, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleImageNotBetween(String value1, String value2) {
            addCriterion("BlogsArticle_image not between", value1, value2, "blogsarticleImage");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentIsNull() {
            addCriterion("BlogsArticle_Content is null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentIsNotNull() {
            addCriterion("BlogsArticle_Content is not null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentEqualTo(String value) {
            addCriterion("BlogsArticle_Content =", value, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentNotEqualTo(String value) {
            addCriterion("BlogsArticle_Content <>", value, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentGreaterThan(String value) {
            addCriterion("BlogsArticle_Content >", value, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentGreaterThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_Content >=", value, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentLessThan(String value) {
            addCriterion("BlogsArticle_Content <", value, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentLessThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_Content <=", value, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentLike(String value) {
            addCriterion("BlogsArticle_Content like", value, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentNotLike(String value) {
            addCriterion("BlogsArticle_Content not like", value, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentIn(List<String> values) {
            addCriterion("BlogsArticle_Content in", values, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentNotIn(List<String> values) {
            addCriterion("BlogsArticle_Content not in", values, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentBetween(String value1, String value2) {
            addCriterion("BlogsArticle_Content between", value1, value2, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleContentNotBetween(String value1, String value2) {
            addCriterion("BlogsArticle_Content not between", value1, value2, "blogsarticleContent");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationIsNull() {
            addCriterion("BlogsArticle_Information is null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationIsNotNull() {
            addCriterion("BlogsArticle_Information is not null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationEqualTo(String value) {
            addCriterion("BlogsArticle_Information =", value, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationNotEqualTo(String value) {
            addCriterion("BlogsArticle_Information <>", value, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationGreaterThan(String value) {
            addCriterion("BlogsArticle_Information >", value, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationGreaterThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_Information >=", value, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationLessThan(String value) {
            addCriterion("BlogsArticle_Information <", value, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationLessThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_Information <=", value, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationLike(String value) {
            addCriterion("BlogsArticle_Information like", value, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationNotLike(String value) {
            addCriterion("BlogsArticle_Information not like", value, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationIn(List<String> values) {
            addCriterion("BlogsArticle_Information in", values, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationNotIn(List<String> values) {
            addCriterion("BlogsArticle_Information not in", values, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationBetween(String value1, String value2) {
            addCriterion("BlogsArticle_Information between", value1, value2, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleInformationNotBetween(String value1, String value2) {
            addCriterion("BlogsArticle_Information not between", value1, value2, "blogsarticleInformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationIsNull() {
            addCriterion("BlogsArticle_DetailedInformation is null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationIsNotNull() {
            addCriterion("BlogsArticle_DetailedInformation is not null");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationEqualTo(String value) {
            addCriterion("BlogsArticle_DetailedInformation =", value, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationNotEqualTo(String value) {
            addCriterion("BlogsArticle_DetailedInformation <>", value, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationGreaterThan(String value) {
            addCriterion("BlogsArticle_DetailedInformation >", value, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationGreaterThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_DetailedInformation >=", value, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationLessThan(String value) {
            addCriterion("BlogsArticle_DetailedInformation <", value, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationLessThanOrEqualTo(String value) {
            addCriterion("BlogsArticle_DetailedInformation <=", value, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationLike(String value) {
            addCriterion("BlogsArticle_DetailedInformation like", value, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationNotLike(String value) {
            addCriterion("BlogsArticle_DetailedInformation not like", value, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationIn(List<String> values) {
            addCriterion("BlogsArticle_DetailedInformation in", values, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationNotIn(List<String> values) {
            addCriterion("BlogsArticle_DetailedInformation not in", values, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationBetween(String value1, String value2) {
            addCriterion("BlogsArticle_DetailedInformation between", value1, value2, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andBlogsarticleDetailedinformationNotBetween(String value1, String value2) {
            addCriterion("BlogsArticle_DetailedInformation not between", value1, value2, "blogsarticleDetailedinformation");
            return (Criteria) this;
        }

        public Criteria andAccessnumberIsNull() {
            addCriterion("AccessNumber is null");
            return (Criteria) this;
        }

        public Criteria andAccessnumberIsNotNull() {
            addCriterion("AccessNumber is not null");
            return (Criteria) this;
        }

        public Criteria andAccessnumberEqualTo(Integer value) {
            addCriterion("AccessNumber =", value, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberNotEqualTo(Integer value) {
            addCriterion("AccessNumber <>", value, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberGreaterThan(Integer value) {
            addCriterion("AccessNumber >", value, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("AccessNumber >=", value, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberLessThan(Integer value) {
            addCriterion("AccessNumber <", value, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberLessThanOrEqualTo(Integer value) {
            addCriterion("AccessNumber <=", value, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberIn(List<Integer> values) {
            addCriterion("AccessNumber in", values, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberNotIn(List<Integer> values) {
            addCriterion("AccessNumber not in", values, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberBetween(Integer value1, Integer value2) {
            addCriterion("AccessNumber between", value1, value2, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andAccessnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("AccessNumber not between", value1, value2, "accessnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberIsNull() {
            addCriterion("CommentNumber is null");
            return (Criteria) this;
        }

        public Criteria andCommentnumberIsNotNull() {
            addCriterion("CommentNumber is not null");
            return (Criteria) this;
        }

        public Criteria andCommentnumberEqualTo(Integer value) {
            addCriterion("CommentNumber =", value, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberNotEqualTo(Integer value) {
            addCriterion("CommentNumber <>", value, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberGreaterThan(Integer value) {
            addCriterion("CommentNumber >", value, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("CommentNumber >=", value, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberLessThan(Integer value) {
            addCriterion("CommentNumber <", value, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberLessThanOrEqualTo(Integer value) {
            addCriterion("CommentNumber <=", value, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberIn(List<Integer> values) {
            addCriterion("CommentNumber in", values, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberNotIn(List<Integer> values) {
            addCriterion("CommentNumber not in", values, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberBetween(Integer value1, Integer value2) {
            addCriterion("CommentNumber between", value1, value2, "commentnumber");
            return (Criteria) this;
        }

        public Criteria andCommentnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("CommentNumber not between", value1, value2, "commentnumber");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}