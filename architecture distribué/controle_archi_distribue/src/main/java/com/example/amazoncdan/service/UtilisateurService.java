package com.example.amazoncdan.service;

import com.example.amazoncdan.dto.UtilisateurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class UtilisateurService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UtilisateurService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UtilisateurDto> getAllUtilisateurs() {
        String sql = "SELECT id, nom, prenom, naissance, inscription, type FROM utilisateur";

        try {
            List<UtilisateurDto> utilisateurs = jdbcTemplate.query(sql, (rs, rowNum) -> {
                UtilisateurDto utilisateur = new UtilisateurDto();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setNaissance(rs.getDate("naissance"));
                utilisateur.setInscription(rs.getDate("inscription"));
                utilisateur.setType(rs.getString("type"));
                return utilisateur;
            });
            return utilisateurs;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list or handle the exception accordingly
        }
    }

    public UtilisateurDto getUtilisateurById(int id) {
        String sql = "SELECT id, nom, prenom, naissance, inscription, type FROM utilisateur WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(UtilisateurDto.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addUtilisateur(UtilisateurDto utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, naissance, inscription, type) VALUES (?, ?, ?, ?, ?)";

        try {
            int rowsInserted = jdbcTemplate.update(sql,
                    utilisateur.getNom(),
                    utilisateur.getPrenom(),
                    utilisateur.getNaissance(),
                    utilisateur.getInscription(),
                    utilisateur.getType());
            return rowsInserted == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int[] countUtilisateursTypes() {
        String sql = "SELECT type, COUNT(*) AS count FROM utilisateur GROUP BY type";

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            int[] counts = new int[3];

            for (Map<String, Object> row : rows) {
                String type = (String) row.get("type");
                int count = ((Number) row.get("count")).intValue();

                switch (type) {
                    case "client":
                        counts[0] = count;
                        break;
                    case "motard":
                        counts[1] = count;
                        break;
                    case "chauffeur":
                        counts[2] = count;
                        break;
                    default:
                        break;
                }
            }

            return counts;
        } catch (Exception e) {
            e.printStackTrace();
            return new int[]{0, 0, 0};
        }
    }
}
