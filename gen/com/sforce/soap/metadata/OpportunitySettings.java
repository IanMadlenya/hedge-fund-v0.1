package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class OpportunitySettings extends com.sforce.soap.metadata.Metadata {

    /**
     * Constructor
     */
    public OpportunitySettings() {}

    /**
     * element : autoActivateNewReminders of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo autoActivateNewReminders__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","autoActivateNewReminders","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean autoActivateNewReminders__is_set = false;

    private boolean autoActivateNewReminders;

    public boolean getAutoActivateNewReminders() {
      return autoActivateNewReminders;
    }

    public boolean isAutoActivateNewReminders() {
      return autoActivateNewReminders;
    }

    public void setAutoActivateNewReminders(boolean autoActivateNewReminders) {
      this.autoActivateNewReminders = autoActivateNewReminders;
      autoActivateNewReminders__is_set = true;
    }

    /**
     * element : enableFindSimilarOpportunities of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo enableFindSimilarOpportunities__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","enableFindSimilarOpportunities","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean enableFindSimilarOpportunities__is_set = false;

    private boolean enableFindSimilarOpportunities;

    public boolean getEnableFindSimilarOpportunities() {
      return enableFindSimilarOpportunities;
    }

    public boolean isEnableFindSimilarOpportunities() {
      return enableFindSimilarOpportunities;
    }

    public void setEnableFindSimilarOpportunities(boolean enableFindSimilarOpportunities) {
      this.enableFindSimilarOpportunities = enableFindSimilarOpportunities;
      enableFindSimilarOpportunities__is_set = true;
    }

    /**
     * element : enableOpportunityTeam of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo enableOpportunityTeam__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","enableOpportunityTeam","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean enableOpportunityTeam__is_set = false;

    private boolean enableOpportunityTeam;

    public boolean getEnableOpportunityTeam() {
      return enableOpportunityTeam;
    }

    public boolean isEnableOpportunityTeam() {
      return enableOpportunityTeam;
    }

    public void setEnableOpportunityTeam(boolean enableOpportunityTeam) {
      this.enableOpportunityTeam = enableOpportunityTeam;
      enableOpportunityTeam__is_set = true;
    }

    /**
     * element : enableUpdateReminders of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo enableUpdateReminders__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","enableUpdateReminders","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean enableUpdateReminders__is_set = false;

    private boolean enableUpdateReminders;

    public boolean getEnableUpdateReminders() {
      return enableUpdateReminders;
    }

    public boolean isEnableUpdateReminders() {
      return enableUpdateReminders;
    }

    public void setEnableUpdateReminders(boolean enableUpdateReminders) {
      this.enableUpdateReminders = enableUpdateReminders;
      enableUpdateReminders__is_set = true;
    }

    /**
     * element : findSimilarOppFilter of type {http://soap.sforce.com/2006/04/metadata}FindSimilarOppFilter
     * java type: com.sforce.soap.metadata.FindSimilarOppFilter
     */
    private static final com.sforce.ws.bind.TypeInfo findSimilarOppFilter__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","findSimilarOppFilter","http://soap.sforce.com/2006/04/metadata","FindSimilarOppFilter",0,1,true);

    private boolean findSimilarOppFilter__is_set = false;

    private com.sforce.soap.metadata.FindSimilarOppFilter findSimilarOppFilter;

    public com.sforce.soap.metadata.FindSimilarOppFilter getFindSimilarOppFilter() {
      return findSimilarOppFilter;
    }

    public void setFindSimilarOppFilter(com.sforce.soap.metadata.FindSimilarOppFilter findSimilarOppFilter) {
      this.findSimilarOppFilter = findSimilarOppFilter;
      findSimilarOppFilter__is_set = true;
    }

    /**
     * element : promptToAddProducts of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo promptToAddProducts__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","promptToAddProducts","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean promptToAddProducts__is_set = false;

    private boolean promptToAddProducts;

    public boolean getPromptToAddProducts() {
      return promptToAddProducts;
    }

    public boolean isPromptToAddProducts() {
      return promptToAddProducts;
    }

    public void setPromptToAddProducts(boolean promptToAddProducts) {
      this.promptToAddProducts = promptToAddProducts;
      promptToAddProducts__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "http://soap.sforce.com/2006/04/metadata", "OpportunitySettings");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeBoolean(__out, autoActivateNewReminders__typeInfo, autoActivateNewReminders, autoActivateNewReminders__is_set);
       __typeMapper.writeBoolean(__out, enableFindSimilarOpportunities__typeInfo, enableFindSimilarOpportunities, enableFindSimilarOpportunities__is_set);
       __typeMapper.writeBoolean(__out, enableOpportunityTeam__typeInfo, enableOpportunityTeam, enableOpportunityTeam__is_set);
       __typeMapper.writeBoolean(__out, enableUpdateReminders__typeInfo, enableUpdateReminders, enableUpdateReminders__is_set);
       __typeMapper.writeObject(__out, findSimilarOppFilter__typeInfo, findSimilarOppFilter, findSimilarOppFilter__is_set);
       __typeMapper.writeBoolean(__out, promptToAddProducts__typeInfo, promptToAddProducts, promptToAddProducts__is_set);
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
        super.loadFields(__in, __typeMapper);
        __in.peekTag();
        if (__typeMapper.isElement(__in, autoActivateNewReminders__typeInfo)) {
            setAutoActivateNewReminders(__typeMapper.readBoolean(__in, autoActivateNewReminders__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, enableFindSimilarOpportunities__typeInfo)) {
            setEnableFindSimilarOpportunities(__typeMapper.readBoolean(__in, enableFindSimilarOpportunities__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, enableOpportunityTeam__typeInfo)) {
            setEnableOpportunityTeam(__typeMapper.readBoolean(__in, enableOpportunityTeam__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, enableUpdateReminders__typeInfo)) {
            setEnableUpdateReminders(__typeMapper.readBoolean(__in, enableUpdateReminders__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, findSimilarOppFilter__typeInfo)) {
            setFindSimilarOppFilter((com.sforce.soap.metadata.FindSimilarOppFilter)__typeMapper.readObject(__in, findSimilarOppFilter__typeInfo, com.sforce.soap.metadata.FindSimilarOppFilter.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, promptToAddProducts__typeInfo)) {
            setPromptToAddProducts(__typeMapper.readBoolean(__in, promptToAddProducts__typeInfo, boolean.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[OpportunitySettings ");
      sb.append(super.toString());sb.append(" autoActivateNewReminders='").append(com.sforce.ws.util.Verbose.toString(autoActivateNewReminders)).append("'\n");
      sb.append(" enableFindSimilarOpportunities='").append(com.sforce.ws.util.Verbose.toString(enableFindSimilarOpportunities)).append("'\n");
      sb.append(" enableOpportunityTeam='").append(com.sforce.ws.util.Verbose.toString(enableOpportunityTeam)).append("'\n");
      sb.append(" enableUpdateReminders='").append(com.sforce.ws.util.Verbose.toString(enableUpdateReminders)).append("'\n");
      sb.append(" findSimilarOppFilter='").append(com.sforce.ws.util.Verbose.toString(findSimilarOppFilter)).append("'\n");
      sb.append(" promptToAddProducts='").append(com.sforce.ws.util.Verbose.toString(promptToAddProducts)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}