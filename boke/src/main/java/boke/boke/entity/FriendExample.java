package boke.boke.entity;

import java.util.ArrayList;
import java.util.List;

public class FriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendExample() {
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

        public Criteria andFriendIdIsNull() {
            addCriterion("Friend_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNotNull() {
            addCriterion("Friend_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendIdEqualTo(Integer value) {
            addCriterion("Friend_id =", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotEqualTo(Integer value) {
            addCriterion("Friend_id <>", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThan(Integer value) {
            addCriterion("Friend_id >", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Friend_id >=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThan(Integer value) {
            addCriterion("Friend_id <", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThanOrEqualTo(Integer value) {
            addCriterion("Friend_id <=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIn(List<Integer> values) {
            addCriterion("Friend_id in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotIn(List<Integer> values) {
            addCriterion("Friend_id not in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdBetween(Integer value1, Integer value2) {
            addCriterion("Friend_id between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Friend_id not between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNull() {
            addCriterion("Friend_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNotNull() {
            addCriterion("Friend_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendNameEqualTo(String value) {
            addCriterion("Friend_name =", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotEqualTo(String value) {
            addCriterion("Friend_name <>", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThan(String value) {
            addCriterion("Friend_name >", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThanOrEqualTo(String value) {
            addCriterion("Friend_name >=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThan(String value) {
            addCriterion("Friend_name <", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThanOrEqualTo(String value) {
            addCriterion("Friend_name <=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLike(String value) {
            addCriterion("Friend_name like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotLike(String value) {
            addCriterion("Friend_name not like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameIn(List<String> values) {
            addCriterion("Friend_name in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotIn(List<String> values) {
            addCriterion("Friend_name not in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameBetween(String value1, String value2) {
            addCriterion("Friend_name between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotBetween(String value1, String value2) {
            addCriterion("Friend_name not between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceIsNull() {
            addCriterion("Self_introduce is null");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceIsNotNull() {
            addCriterion("Self_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceEqualTo(String value) {
            addCriterion("Self_introduce =", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceNotEqualTo(String value) {
            addCriterion("Self_introduce <>", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceGreaterThan(String value) {
            addCriterion("Self_introduce >", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("Self_introduce >=", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceLessThan(String value) {
            addCriterion("Self_introduce <", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceLessThanOrEqualTo(String value) {
            addCriterion("Self_introduce <=", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceLike(String value) {
            addCriterion("Self_introduce like", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceNotLike(String value) {
            addCriterion("Self_introduce not like", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceIn(List<String> values) {
            addCriterion("Self_introduce in", values, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceNotIn(List<String> values) {
            addCriterion("Self_introduce not in", values, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceBetween(String value1, String value2) {
            addCriterion("Self_introduce between", value1, value2, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceNotBetween(String value1, String value2) {
            addCriterion("Self_introduce not between", value1, value2, "selfIntroduce");
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

        public Criteria andPortraitIsNull() {
            addCriterion("Portrait is null");
            return (Criteria) this;
        }

        public Criteria andPortraitIsNotNull() {
            addCriterion("Portrait is not null");
            return (Criteria) this;
        }

        public Criteria andPortraitEqualTo(String value) {
            addCriterion("Portrait =", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitNotEqualTo(String value) {
            addCriterion("Portrait <>", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitGreaterThan(String value) {
            addCriterion("Portrait >", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("Portrait >=", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitLessThan(String value) {
            addCriterion("Portrait <", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitLessThanOrEqualTo(String value) {
            addCriterion("Portrait <=", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitLike(String value) {
            addCriterion("Portrait like", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitNotLike(String value) {
            addCriterion("Portrait not like", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitIn(List<String> values) {
            addCriterion("Portrait in", values, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitNotIn(List<String> values) {
            addCriterion("Portrait not in", values, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitBetween(String value1, String value2) {
            addCriterion("Portrait between", value1, value2, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitNotBetween(String value1, String value2) {
            addCriterion("Portrait not between", value1, value2, "portrait");
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