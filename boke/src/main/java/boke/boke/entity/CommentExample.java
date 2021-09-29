package boke.boke.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("Comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("Comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("Comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("Comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("Comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("Comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("Comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("Comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("Comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("Comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andMessageNameIsNull() {
            addCriterion("Message_name is null");
            return (Criteria) this;
        }

        public Criteria andMessageNameIsNotNull() {
            addCriterion("Message_name is not null");
            return (Criteria) this;
        }

        public Criteria andMessageNameEqualTo(String value) {
            addCriterion("Message_name =", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotEqualTo(String value) {
            addCriterion("Message_name <>", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameGreaterThan(String value) {
            addCriterion("Message_name >", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameGreaterThanOrEqualTo(String value) {
            addCriterion("Message_name >=", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLessThan(String value) {
            addCriterion("Message_name <", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLessThanOrEqualTo(String value) {
            addCriterion("Message_name <=", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLike(String value) {
            addCriterion("Message_name like", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotLike(String value) {
            addCriterion("Message_name not like", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameIn(List<String> values) {
            addCriterion("Message_name in", values, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotIn(List<String> values) {
            addCriterion("Message_name not in", values, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameBetween(String value1, String value2) {
            addCriterion("Message_name between", value1, value2, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotBetween(String value1, String value2) {
            addCriterion("Message_name not between", value1, value2, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageEmailIsNull() {
            addCriterion("Message_email is null");
            return (Criteria) this;
        }

        public Criteria andMessageEmailIsNotNull() {
            addCriterion("Message_email is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEmailEqualTo(String value) {
            addCriterion("Message_email =", value, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailNotEqualTo(String value) {
            addCriterion("Message_email <>", value, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailGreaterThan(String value) {
            addCriterion("Message_email >", value, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Message_email >=", value, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailLessThan(String value) {
            addCriterion("Message_email <", value, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailLessThanOrEqualTo(String value) {
            addCriterion("Message_email <=", value, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailLike(String value) {
            addCriterion("Message_email like", value, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailNotLike(String value) {
            addCriterion("Message_email not like", value, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailIn(List<String> values) {
            addCriterion("Message_email in", values, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailNotIn(List<String> values) {
            addCriterion("Message_email not in", values, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailBetween(String value1, String value2) {
            addCriterion("Message_email between", value1, value2, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andMessageEmailNotBetween(String value1, String value2) {
            addCriterion("Message_email not between", value1, value2, "messageEmail");
            return (Criteria) this;
        }

        public Criteria andDirectSiteIsNull() {
            addCriterion("Direct_site is null");
            return (Criteria) this;
        }

        public Criteria andDirectSiteIsNotNull() {
            addCriterion("Direct_site is not null");
            return (Criteria) this;
        }

        public Criteria andDirectSiteEqualTo(String value) {
            addCriterion("Direct_site =", value, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteNotEqualTo(String value) {
            addCriterion("Direct_site <>", value, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteGreaterThan(String value) {
            addCriterion("Direct_site >", value, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteGreaterThanOrEqualTo(String value) {
            addCriterion("Direct_site >=", value, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteLessThan(String value) {
            addCriterion("Direct_site <", value, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteLessThanOrEqualTo(String value) {
            addCriterion("Direct_site <=", value, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteLike(String value) {
            addCriterion("Direct_site like", value, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteNotLike(String value) {
            addCriterion("Direct_site not like", value, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteIn(List<String> values) {
            addCriterion("Direct_site in", values, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteNotIn(List<String> values) {
            addCriterion("Direct_site not in", values, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteBetween(String value1, String value2) {
            addCriterion("Direct_site between", value1, value2, "directSite");
            return (Criteria) this;
        }

        public Criteria andDirectSiteNotBetween(String value1, String value2) {
            addCriterion("Direct_site not between", value1, value2, "directSite");
            return (Criteria) this;
        }

        public Criteria andCommentDateIsNull() {
            addCriterion("Comment_Date is null");
            return (Criteria) this;
        }

        public Criteria andCommentDateIsNotNull() {
            addCriterion("Comment_Date is not null");
            return (Criteria) this;
        }

        public Criteria andCommentDateEqualTo(Date value) {
            addCriterionForJDBCDate("Comment_Date =", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("Comment_Date <>", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateGreaterThan(Date value) {
            addCriterionForJDBCDate("Comment_Date >", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Comment_Date >=", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLessThan(Date value) {
            addCriterionForJDBCDate("Comment_Date <", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Comment_Date <=", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateIn(List<Date> values) {
            addCriterionForJDBCDate("Comment_Date in", values, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("Comment_Date not in", values, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Comment_Date between", value1, value2, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Comment_Date not between", value1, value2, "commentDate");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageIsNull() {
            addCriterion("Voice_message is null");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageIsNotNull() {
            addCriterion("Voice_message is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageEqualTo(String value) {
            addCriterion("Voice_message =", value, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageNotEqualTo(String value) {
            addCriterion("Voice_message <>", value, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageGreaterThan(String value) {
            addCriterion("Voice_message >", value, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageGreaterThanOrEqualTo(String value) {
            addCriterion("Voice_message >=", value, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageLessThan(String value) {
            addCriterion("Voice_message <", value, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageLessThanOrEqualTo(String value) {
            addCriterion("Voice_message <=", value, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageLike(String value) {
            addCriterion("Voice_message like", value, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageNotLike(String value) {
            addCriterion("Voice_message not like", value, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageIn(List<String> values) {
            addCriterion("Voice_message in", values, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageNotIn(List<String> values) {
            addCriterion("Voice_message not in", values, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageBetween(String value1, String value2) {
            addCriterion("Voice_message between", value1, value2, "voiceMessage");
            return (Criteria) this;
        }

        public Criteria andVoiceMessageNotBetween(String value1, String value2) {
            addCriterion("Voice_message not between", value1, value2, "voiceMessage");
            return (Criteria) this;
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

        public Criteria andMessageReplyIsNull() {
            addCriterion("Message_reply is null");
            return (Criteria) this;
        }

        public Criteria andMessageReplyIsNotNull() {
            addCriterion("Message_reply is not null");
            return (Criteria) this;
        }

        public Criteria andMessageReplyEqualTo(Integer value) {
            addCriterion("Message_reply =", value, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyNotEqualTo(Integer value) {
            addCriterion("Message_reply <>", value, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyGreaterThan(Integer value) {
            addCriterion("Message_reply >", value, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("Message_reply >=", value, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyLessThan(Integer value) {
            addCriterion("Message_reply <", value, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyLessThanOrEqualTo(Integer value) {
            addCriterion("Message_reply <=", value, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyIn(List<Integer> values) {
            addCriterion("Message_reply in", values, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyNotIn(List<Integer> values) {
            addCriterion("Message_reply not in", values, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyBetween(Integer value1, Integer value2) {
            addCriterion("Message_reply between", value1, value2, "messageReply");
            return (Criteria) this;
        }

        public Criteria andMessageReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("Message_reply not between", value1, value2, "messageReply");
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