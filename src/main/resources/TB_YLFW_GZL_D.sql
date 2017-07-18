SELECT
  C.F_YEAR                 AS F_YEAR,
  C.F_SEASON               AS F_QUARTER,
  C.F_MONTH                AS F_MONTH,
  C.F_WEEK                 AS F_WEEK,
  C.F_DAY                  AS F_DAY,
  NVL(TD.F_SJQJ, '02')     AS F_SJQJ,
  D.XNXZQHDM               AS F_XZQX_DM,
  E.SJJGID                 AS F_SJQH_DM,
  A.YLJGDMID               AS F_YLJG_ID,
  SUBSTR(D.WSJGLBDM, 1, 4) AS F_YLJG_TYPE,
  D.JGLSGXDM               AS F_YLJG_JGLSGXDM,
  SUBSTR(A.YSKSPTDM, 1, 2) AS F_KS_DM,
  A.YSID                   AS F_YS_UUID,
  A.GHYSGH                 AS F_YS_GH,
  A.GHYSXM                 AS F_YS_MC,
  B.XB                     AS F_XB,
  B.CSRQ     AS F_YNDM,
  SUM(CASE
      WHEN A.GTHBZ = '1'
        THEN
          1
      WHEN A.GTHBZ = '2'
        THEN
          -1
      ELSE
        0
      END)                 AS MZRC,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND A.LCYXLXBM <> '01'
        THEN
          1
      WHEN A.GTHBZ = '2' AND A.LCYXLXBM <> '01'
        THEN
          -1
      ELSE
        0
      END)                 AS MZRC_ZY,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND A.LCYXLXBM = '01'
        THEN
          1
      WHEN A.GTHBZ = '2' AND A.LCYXLXBM = '01'
        THEN
          -1
      ELSE
        0
      END)                 AS MZRC_XY,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND A.SFJZ = '0'
        THEN
          1
      WHEN A.GTHBZ = '2' AND A.SFJZ = '0'
        THEN
          -1
      ELSE
        0
      END)                 AS PTMZRC,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND A.SFJZ = '0' AND
           A.LCYXLXBM <> '01'
        THEN
          1
      WHEN A.GTHBZ = '2' AND A.SFJZ = '0' AND
           A.LCYXLXBM <> '01'
        THEN
          -1
      ELSE
        0
      END)                 AS PTMZRC_ZY,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND A.SFJZ = '0' AND
           A.LCYXLXBM = '01'
        THEN
          1
      WHEN A.GTHBZ = '2' AND A.SFJZ = '0' AND
           A.LCYXLXBM = '01'
        THEN
          -1
      ELSE
        0
      END)                 AS PTMZRC_XY,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND A.SFJZ <> '0'
        THEN
          1
      WHEN A.GTHBZ = '2' AND A.SFJZ <> '0'
        THEN
          -1
      ELSE
        0
      END)                 AS MJZRC,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND
           A.GHTJBM IN ('02',
                        '0201',
                        '0299',
                        '03',
                        '0301',
                        '0302',
                        '0399',
                        '04',
                        '0401',
                        '0499')
        THEN
          1
      WHEN A.GTHBZ = '2' AND
           A.GHTJBM IN ('02',
                        '0201',
                        '0299',
                        '03',
                        '0301',
                        '0302',
                        '0399',
                        '04',
                        '0401',
                        '0499')
        THEN
          -1
      ELSE
        0
      END)                 AS YYZLRC,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND
           A.GHTJBM IN ('02',
                        '0201',
                        '0299',
                        '03',
                        '0301',
                        '0302',
                        '0399',
                        '04',
                        '0401',
                        '0499') AND A.LCYXLXBM <> '01'
        THEN
          1
      WHEN A.GTHBZ = '2' AND
           A.GHTJBM IN ('02',
                        '0201',
                        '0299',
                        '03',
                        '0301',
                        '0302',
                        '0399',
                        '04',
                        '0401',
                        '0499') AND A.LCYXLXBM <> '01'
        THEN
          -1
      ELSE
        0
      END)                 AS YYZLRC_ZY,
  SUM(CASE
      WHEN A.GTHBZ = '1' AND
           A.GHTJBM IN ('02',
                        '0201',
                        '0299',
                        '03',
                        '0301',
                        '0302',
                        '0399',
                        '04',
                        '0401',
                        '0499') AND A.LCYXLXBM = '01'
        THEN
          1
      WHEN A.GTHBZ = '2' AND
           A.GHTJBM IN ('02',
                        '0201',
                        '0299',
                        '03',
                        '0301',
                        '0302',
                        '0399',
                        '04',
                        '0401',
                        '0499') AND A.LCYXLXBM = '01'
        THEN
          -1
      ELSE
        0
      END)                 AS YYZLRC_XY,
  0                        AS MZJZRC,
  0                        AS MZJZRC_ZY,
  0                        AS MZJZRC_XY,
  0                        AS RYRC,
  0                        AS RYRC_ZY,
  0                        AS RYRC_XY,
  0                        AS CYRC,
  0                        AS CYRC_ZY,
  0                        AS CYRC_XY,
  0                        AS SSZRC,
  0                        AS MZSSZRC,
  0                        AS ZYSSZRC
FROM TB_MZ_GHMXB A
  LEFT JOIN TB_HIS_PATINF B
    ON A.BRWYID = B.BRWYID AND a.kh = b.kh AND a.klx = b.klx
  LEFT JOIN TB_DIC_SJQJ TD
    ON F_START_TIME <= substr(A.GTHSJ,12,8)
       AND F_END_TIME > substr(A.GTHSJ,12,8)
  LEFT JOIN TB_DIC_NNQJ TY
    ON F_START_NN <=
       FLOOR(MONTHS_BETWEEN(A.GTHSJ, NVL(B.CSRQ, A.GTHSJ)) / 12)
       AND F_END_NN >=
           FLOOR(MONTHS_BETWEEN(A.GTHSJ, NVL(B.CSRQ, A.GTHSJ)) / 12)
  INNER JOIN TB_DIC_DIM_DATE C
    ON SUBSTR(A.GTHSJ,0,10)=SUBSTR(C.F_TODAY,0,10)
  INNER JOIN TB_DIC_WD_YLJGZDB D
    ON A.YLJGDMID = D.YLJGID
  INNER JOIN TB_DIC_WD_WSXZJGZDB E
    ON D.XNXZQHDM = E.XZQHDM
GROUP BY C.F_YEAR,
  C.F_SEASON,
  C.F_MONTH,
  C.F_WEEK,
  C.F_DAY,
  NVL(TD.F_SJQJ, '02'),
  D.XNXZQHDM,
  E.SJJGID,
  A.YLJGDMID,
  SUBSTR(D.WSJGLBDM, 1, 4),
  D.JGLSGXDM,
  SUBSTR(A.YSKSPTDM, 1, 2),
  A.YSID,
  A.GHYSGH,
  A.GHYSXM,
  B.XB,
  B.CSRQ