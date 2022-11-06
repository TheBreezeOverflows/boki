package boke.boke.util;

import org.springframework.data.elasticsearch.core.query.SourceFilter;

/**
 * es搜索需要查询字段的设定
 */
public class FetchSourceFilter implements SourceFilter {
    private final String[] includes; //需要被查询的字段
    private final String[] excludes; //不需要被查询的字段(被过滤的子字段)

    public FetchSourceFilter(final String[] includes, final String[] excludes) {
        this.includes = includes;
        this.excludes = excludes;
    }

    @Override
    public String[] getIncludes() {
        return includes;
    }

    @Override
    public String[] getExcludes() {
        return excludes;
    }
}
