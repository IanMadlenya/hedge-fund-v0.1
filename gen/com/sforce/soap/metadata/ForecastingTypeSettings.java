package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class ForecastingTypeSettings implements com.sforce.ws.bind.XMLizable {

    /**
     * Constructor
     */
    public ForecastingTypeSettings() {}

    /**
     * element : active of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo active__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","active","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean active__is_set = false;

    private boolean active;

    public boolean getActive() {
      return active;
    }

    public boolean isActive() {
      return active;
    }

    public void setActive(boolean active) {
      this.active = active;
      active__is_set = true;
    }

    /**
     * element : adjustmentsSettings of type {http://soap.sforce.com/2006/04/metadata}AdjustmentsSettings
     * java type: com.sforce.soap.metadata.AdjustmentsSettings
     */
    private static final com.sforce.ws.bind.TypeInfo adjustmentsSettings__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","adjustmentsSettings","http://soap.sforce.com/2006/04/metadata","AdjustmentsSettings",1,1,true);

    private boolean adjustmentsSettings__is_set = false;

    private com.sforce.soap.metadata.AdjustmentsSettings adjustmentsSettings;

    public com.sforce.soap.metadata.AdjustmentsSettings getAdjustmentsSettings() {
      return adjustmentsSettings;
    }

    public void setAdjustmentsSettings(com.sforce.soap.metadata.AdjustmentsSettings adjustmentsSettings) {
      this.adjustmentsSettings = adjustmentsSettings;
      adjustmentsSettings__is_set = true;
    }

    /**
     * element : forecastRangeSettings of type {http://soap.sforce.com/2006/04/metadata}ForecastRangeSettings
     * java type: com.sforce.soap.metadata.ForecastRangeSettings
     */
    private static final com.sforce.ws.bind.TypeInfo forecastRangeSettings__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","forecastRangeSettings","http://soap.sforce.com/2006/04/metadata","ForecastRangeSettings",1,1,true);

    private boolean forecastRangeSettings__is_set = false;

    private com.sforce.soap.metadata.ForecastRangeSettings forecastRangeSettings;

    public com.sforce.soap.metadata.ForecastRangeSettings getForecastRangeSettings() {
      return forecastRangeSettings;
    }

    public void setForecastRangeSettings(com.sforce.soap.metadata.ForecastRangeSettings forecastRangeSettings) {
      this.forecastRangeSettings = forecastRangeSettings;
      forecastRangeSettings__is_set = true;
    }

    /**
     * element : name of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo name__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","name","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean name__is_set = false;

    private java.lang.String name;

    public java.lang.String getName() {
      return name;
    }

    public void setName(java.lang.String name) {
      this.name = name;
      name__is_set = true;
    }

    /**
     * element : opportunityListFieldsSelectedSettings of type {http://soap.sforce.com/2006/04/metadata}OpportunityListFieldsSelectedSettings
     * java type: com.sforce.soap.metadata.OpportunityListFieldsSelectedSettings
     */
    private static final com.sforce.ws.bind.TypeInfo opportunityListFieldsSelectedSettings__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","opportunityListFieldsSelectedSettings","http://soap.sforce.com/2006/04/metadata","OpportunityListFieldsSelectedSettings",1,1,true);

    private boolean opportunityListFieldsSelectedSettings__is_set = false;

    private com.sforce.soap.metadata.OpportunityListFieldsSelectedSettings opportunityListFieldsSelectedSettings;

    public com.sforce.soap.metadata.OpportunityListFieldsSelectedSettings getOpportunityListFieldsSelectedSettings() {
      return opportunityListFieldsSelectedSettings;
    }

    public void setOpportunityListFieldsSelectedSettings(com.sforce.soap.metadata.OpportunityListFieldsSelectedSettings opportunityListFieldsSelectedSettings) {
      this.opportunityListFieldsSelectedSettings = opportunityListFieldsSelectedSettings;
      opportunityListFieldsSelectedSettings__is_set = true;
    }

    /**
     * element : quotasSettings of type {http://soap.sforce.com/2006/04/metadata}QuotasSettings
     * java type: com.sforce.soap.metadata.QuotasSettings
     */
    private static final com.sforce.ws.bind.TypeInfo quotasSettings__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","quotasSettings","http://soap.sforce.com/2006/04/metadata","QuotasSettings",1,1,true);

    private boolean quotasSettings__is_set = false;

    private com.sforce.soap.metadata.QuotasSettings quotasSettings;

    public com.sforce.soap.metadata.QuotasSettings getQuotasSettings() {
      return quotasSettings;
    }

    public void setQuotasSettings(com.sforce.soap.metadata.QuotasSettings quotasSettings) {
      this.quotasSettings = quotasSettings;
      quotasSettings__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeBoolean(__out, active__typeInfo, active, active__is_set);
       __typeMapper.writeObject(__out, adjustmentsSettings__typeInfo, adjustmentsSettings, adjustmentsSettings__is_set);
       __typeMapper.writeObject(__out, forecastRangeSettings__typeInfo, forecastRangeSettings, forecastRangeSettings__is_set);
       __typeMapper.writeString(__out, name__typeInfo, name, name__is_set);
       __typeMapper.writeObject(__out, opportunityListFieldsSelectedSettings__typeInfo, opportunityListFieldsSelectedSettings, opportunityListFieldsSelectedSettings__is_set);
       __typeMapper.writeObject(__out, quotasSettings__typeInfo, quotasSettings, quotasSettings__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, active__typeInfo)) {
            setActive(__typeMapper.readBoolean(__in, active__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, adjustmentsSettings__typeInfo)) {
            setAdjustmentsSettings((com.sforce.soap.metadata.AdjustmentsSettings)__typeMapper.readObject(__in, adjustmentsSettings__typeInfo, com.sforce.soap.metadata.AdjustmentsSettings.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, forecastRangeSettings__typeInfo)) {
            setForecastRangeSettings((com.sforce.soap.metadata.ForecastRangeSettings)__typeMapper.readObject(__in, forecastRangeSettings__typeInfo, com.sforce.soap.metadata.ForecastRangeSettings.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, name__typeInfo)) {
            setName(__typeMapper.readString(__in, name__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, opportunityListFieldsSelectedSettings__typeInfo)) {
            setOpportunityListFieldsSelectedSettings((com.sforce.soap.metadata.OpportunityListFieldsSelectedSettings)__typeMapper.readObject(__in, opportunityListFieldsSelectedSettings__typeInfo, com.sforce.soap.metadata.OpportunityListFieldsSelectedSettings.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, quotasSettings__typeInfo)) {
            setQuotasSettings((com.sforce.soap.metadata.QuotasSettings)__typeMapper.readObject(__in, quotasSettings__typeInfo, com.sforce.soap.metadata.QuotasSettings.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[ForecastingTypeSettings ");
      sb.append(" active='").append(com.sforce.ws.util.Verbose.toString(active)).append("'\n");
      sb.append(" adjustmentsSettings='").append(com.sforce.ws.util.Verbose.toString(adjustmentsSettings)).append("'\n");
      sb.append(" forecastRangeSettings='").append(com.sforce.ws.util.Verbose.toString(forecastRangeSettings)).append("'\n");
      sb.append(" name='").append(com.sforce.ws.util.Verbose.toString(name)).append("'\n");
      sb.append(" opportunityListFieldsSelectedSettings='").append(com.sforce.ws.util.Verbose.toString(opportunityListFieldsSelectedSettings)).append("'\n");
      sb.append(" quotasSettings='").append(com.sforce.ws.util.Verbose.toString(quotasSettings)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}