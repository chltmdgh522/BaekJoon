WITH RECURSIVE CTE AS (
    -- 최상위 부모에 대한 정의
    SELECT
        id,
        parent_id,
        1 AS lvl
    FROM ecoli_data
    WHERE parent_id IS NULL
    UNION ALL
    -- 자식에 대한 정의 (부모와 관계)
    SELECT
        c.id,
        c.parent_id,
        p.lvl + 1
    FROM CTE p JOIN ecoli_data c ON c.parent_id = p.id
)
SELECT
    COUNT(*) AS COUNT, 
    lvl AS GENERATION
FROM CTE a
WHERE NOT EXISTS (SELECT 1 FROM ecoli_data b WHERE b.parent_id = a.id)
GROUP BY 2
ORDER BY 2;