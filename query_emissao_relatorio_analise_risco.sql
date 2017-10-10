use historyrisk;

SELECT distinct 
       risco.DS_RISCO
     , risco.NU_PERCT_PROB_RISCO
     , catg.DS_CATG_RISCO
     , subcatg.DS_SUBCATG_RISCO
     , prob.DS_FAIXA_PROB
     , ipcto.DS_NIVEL_IPCTO
     , ipcto.NM_NIVEL_IPCTO
     , ipcto.IC_NIVEL_IPCTO
     , risco.VL_CUSTO_ESPRD_RISCO_NGTV
     , risco.VL_CUSTO_ESPRD_RISCO_PSTV
     , pjrt.DS_PRJT     
     , empr.NM_SETOR_EMPR
     , 0 vme
     , 0 risco_geral
     , pjrt.ID_HRSK_PRJT
     , pjrt.DT_INCS
     , pjrt.NU_MATR_INCS
     , usua.NM_USUA
FROM historyrisk.tb_hrsk_risco risco
   , historyrisk.tb_setor_empr empr
   , historyrisk.tb_hrsk_prjt pjrt
   , historyrisk.tb_hrsk_catg_risco catg
   , historyrisk.tb_hrsk_faixa_prob prob
   , historyrisk.tb_hrsk_nivel_ipcto ipcto
   , historyrisk.tb_hrsk_subcatg_risco subcatg
   , historyrisk.tb_hrsk_usua usua
where risco.ID_CATG_RISCO = catg.ID_CATG_RISCO
  and catg.ID_CATG_RISCO = subcatg.ID_CATG_RISCO
  and risco.ID_SUBCATG_RISCO = subcatg.ID_SUBCATG_RISCO
  and risco.ID_FAIXA_PROB = prob.ID_FAIXA_PROB
  and risco.ID_NIVEL_IPCTO = ipcto.ID_NIVEL_IPCTO
  and risco.ID_HRSK_PRJT = pjrt.ID_HRSK_PRJT
  and empr.ID_SETOR_EMPR = pjrt.ID_SETOR_EMPR
  and usua.NU_MATR_USUA = pjrt.NU_MATR_INCS


