package com.voltix.backend.config;

/**
 * Padrão Singleton - GoF
 * Utilizado para garantir que exista apenas uma instância desta classe de configurações
 * durante todo o ciclo de vida da aplicação.
 */
public class GlobalConfigManager {

    private static GlobalConfigManager instance;

    // Exemplos de propriedades globais
    private String defaultCurrency;
    private double baseTaxRate;

    // Construtor privado para evitar instanciação direta
    private GlobalConfigManager() {
        this.defaultCurrency = "BRL";
        this.baseTaxRate = 0.05; // 5%
    }

    // Método estático para recuperar a única instância (Singleton)
    public static synchronized GlobalConfigManager getInstance() {
        if (instance == null) {
            instance = new GlobalConfigManager();
        }
        return instance;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public double getBaseTaxRate() {
        return baseTaxRate;
    }

    public void setBaseTaxRate(double baseTaxRate) {
        this.baseTaxRate = baseTaxRate;
    }
}
