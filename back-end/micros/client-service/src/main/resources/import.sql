-- Réinitialiser l'ID si nécessaire
DELETE FROM Client;

-- Insérer des données sans spécifier d'ID
INSERT INTO Client (name, email, phone) VALUES ('John Doe', 'john.doe@example.com', '123-456-7890');
INSERT INTO Client (name, email, phone) VALUES ('Jane Smith', 'jane.smith@example.com', '098-765-4321');

-- (Facultatif) Redémarrer l'auto-incrémentation si vous avez défini manuellement des IDs
ALTER TABLE Client ALTER COLUMN id RESTART WITH 3;