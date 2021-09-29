package boke.boke.entity;

import java.util.ArrayList;
import java.util.List;

public class BlogandclassifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogandclassifyExample() {
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

        public Criteria andClassifyIdIsNull() {
            addCriterion("Classify_id is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIsNotNull() {
            addCriterion("Classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyIdEqualTo(Integer value) {
            addCriterion("Classify_id =", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotEqualTo(Integer value) {
            addCriterion("Classify_id <>", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdGreaterThan(Integer value) {
            addCriterion("Classify_id >", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Classify_id >=", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLessThan(Integer value) {
            addCriterion("Classify_id <", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLessThanOrEqualTo(Integer value) {
            addCriterion("Classify_id <=", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIn(List<Integer> values) {
            addCriterion("Classify_id in", values, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotIn(List<Integer> values) {
            addCriterion("Classify_id not in", values, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdBetween(Integer value1, Integer value2) {
            addCriterion("Classify_id between", value1, value2, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Classify_id not between", value1, value2, "classifyId");
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