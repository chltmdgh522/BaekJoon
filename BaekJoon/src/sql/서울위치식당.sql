-- 코드를 입력하세요
SELECT a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, ROUND(AVG(b.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO a INNER JOIN REST_REVIEW b ON a.REST_ID = b.REST_ID
WHERE a.ADDRESS LIKE '서울%'
GROUP BY b.REST_ID
ORDER BY ROUND(AVG(b.REVIEW_SCORE), 2) DESC, a.FAVORITES DESC;