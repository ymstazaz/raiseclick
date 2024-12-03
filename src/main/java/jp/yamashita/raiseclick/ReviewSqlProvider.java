package jp.yamashita.raiseclick;

public class ReviewSqlProvider {
    public String buildSearchQuery(SearchCriteria criteria) {
        StringBuilder sql = new StringBuilder("""
           select
              r.id,
              r.situation,
              r.review_age,
              r.review_gender,
              r.free_comment,
              r.created_at,
              s.id as spot_id,
              s.spot_name,
              rp.id as review_purpose_id,
              rp.nth_purpose,
              rp.satisfaction,
              p.id as purpose_id,
              p.purpose_name
           from
              review r
           left join
              spot s on s.id = r.spot_id
           left join
              review_purpose rp on rp.review_id = r.id
           left join
              purpose p on p.id = rp.purpose_id
           WHERE 1=1
           """);

        if (criteria.getSituation() != null) {
            sql.append(" AND r.situation LIKE #{situation}");
        }
        if (criteria.getSpotName() != null) {
            sql.append(" AND s.spot_name LIKE #{spotName}");
        }
        if (criteria.getPurposeName() != null) {
            sql.append(" AND p.purpose_name LIKE #{purposeName}");
        }
        return sql.toString();
    }
}
