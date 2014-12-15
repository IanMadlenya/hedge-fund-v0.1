package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class ReportAggregate implements com.sforce.ws.bind.XMLizable {

    /**
     * Constructor
     */
    public ReportAggregate() {}

    /**
     * element : acrossGroupingContext of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo acrossGroupingContext__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","acrossGroupingContext","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean acrossGroupingContext__is_set = false;

    private java.lang.String acrossGroupingContext;

    public java.lang.String getAcrossGroupingContext() {
      return acrossGroupingContext;
    }

    public void setAcrossGroupingContext(java.lang.String acrossGroupingContext) {
      this.acrossGroupingContext = acrossGroupingContext;
      acrossGroupingContext__is_set = true;
    }

    /**
     * element : calculatedFormula of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo calculatedFormula__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","calculatedFormula","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean calculatedFormula__is_set = false;

    private java.lang.String calculatedFormula;

    public java.lang.String getCalculatedFormula() {
      return calculatedFormula;
    }

    public void setCalculatedFormula(java.lang.String calculatedFormula) {
      this.calculatedFormula = calculatedFormula;
      calculatedFormula__is_set = true;
    }

    /**
     * element : datatype of type {http://soap.sforce.com/2006/04/metadata}ReportAggregateDatatype
     * java type: com.sforce.soap.metadata.ReportAggregateDatatype
     */
    private static final com.sforce.ws.bind.TypeInfo datatype__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","datatype","http://soap.sforce.com/2006/04/metadata","ReportAggregateDatatype",1,1,true);

    private boolean datatype__is_set = false;

    private com.sforce.soap.metadata.ReportAggregateDatatype datatype;

    public com.sforce.soap.metadata.ReportAggregateDatatype getDatatype() {
      return datatype;
    }

    public void setDatatype(com.sforce.soap.metadata.ReportAggregateDatatype datatype) {
      this.datatype = datatype;
      datatype__is_set = true;
    }

    /**
     * element : description of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo description__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","description","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean description__is_set = false;

    private java.lang.String description;

    public java.lang.String getDescription() {
      return description;
    }

    public void setDescription(java.lang.String description) {
      this.description = description;
      description__is_set = true;
    }

    /**
     * element : developerName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo developerName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","developerName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean developerName__is_set = false;

    private java.lang.String developerName;

    public java.lang.String getDeveloperName() {
      return developerName;
    }

    public void setDeveloperName(java.lang.String developerName) {
      this.developerName = developerName;
      developerName__is_set = true;
    }

    /**
     * element : downGroupingContext of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo downGroupingContext__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","downGroupingContext","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean downGroupingContext__is_set = false;

    private java.lang.String downGroupingContext;

    public java.lang.String getDownGroupingContext() {
      return downGroupingContext;
    }

    public void setDownGroupingContext(java.lang.String downGroupingContext) {
      this.downGroupingContext = downGroupingContext;
      downGroupingContext__is_set = true;
    }

    /**
     * element : isActive of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo isActive__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","isActive","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean isActive__is_set = false;

    private boolean isActive;

    public boolean getIsActive() {
      return isActive;
    }

    public boolean isIsActive() {
      return isActive;
    }

    public void setIsActive(boolean isActive) {
      this.isActive = isActive;
      isActive__is_set = true;
    }

    /**
     * element : isCrossBlock of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo isCrossBlock__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","isCrossBlock","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean isCrossBlock__is_set = false;

    private boolean isCrossBlock;

    public boolean getIsCrossBlock() {
      return isCrossBlock;
    }

    public boolean isIsCrossBlock() {
      return isCrossBlock;
    }

    public void setIsCrossBlock(boolean isCrossBlock) {
      this.isCrossBlock = isCrossBlock;
      isCrossBlock__is_set = true;
    }

    /**
     * element : masterLabel of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo masterLabel__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","masterLabel","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean masterLabel__is_set = false;

    private java.lang.String masterLabel;

    public java.lang.String getMasterLabel() {
      return masterLabel;
    }

    public void setMasterLabel(java.lang.String masterLabel) {
      this.masterLabel = masterLabel;
      masterLabel__is_set = true;
    }

    /**
     * element : reportType of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo reportType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","reportType","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean reportType__is_set = false;

    private java.lang.String reportType;

    public java.lang.String getReportType() {
      return reportType;
    }

    public void setReportType(java.lang.String reportType) {
      this.reportType = reportType;
      reportType__is_set = true;
    }

    /**
     * element : scale of type {http://www.w3.org/2001/XMLSchema}int
     * java type: int
     */
    private static final com.sforce.ws.bind.TypeInfo scale__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","scale","http://www.w3.org/2001/XMLSchema","int",0,1,true);

    private boolean scale__is_set = false;

    private int scale;

    public int getScale() {
      return scale;
    }

    public void setScale(int scale) {
      this.scale = scale;
      scale__is_set = true;
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
       __typeMapper.writeString(__out, acrossGroupingContext__typeInfo, acrossGroupingContext, acrossGroupingContext__is_set);
       __typeMapper.writeString(__out, calculatedFormula__typeInfo, calculatedFormula, calculatedFormula__is_set);
       __typeMapper.writeObject(__out, datatype__typeInfo, datatype, datatype__is_set);
       __typeMapper.writeString(__out, description__typeInfo, description, description__is_set);
       __typeMapper.writeString(__out, developerName__typeInfo, developerName, developerName__is_set);
       __typeMapper.writeString(__out, downGroupingContext__typeInfo, downGroupingContext, downGroupingContext__is_set);
       __typeMapper.writeBoolean(__out, isActive__typeInfo, isActive, isActive__is_set);
       __typeMapper.writeBoolean(__out, isCrossBlock__typeInfo, isCrossBlock, isCrossBlock__is_set);
       __typeMapper.writeString(__out, masterLabel__typeInfo, masterLabel, masterLabel__is_set);
       __typeMapper.writeString(__out, reportType__typeInfo, reportType, reportType__is_set);
       __typeMapper.writeInt(__out, scale__typeInfo, scale, scale__is_set);
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
        if (__typeMapper.isElement(__in, acrossGroupingContext__typeInfo)) {
            setAcrossGroupingContext(__typeMapper.readString(__in, acrossGroupingContext__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, calculatedFormula__typeInfo)) {
            setCalculatedFormula(__typeMapper.readString(__in, calculatedFormula__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, datatype__typeInfo)) {
            setDatatype((com.sforce.soap.metadata.ReportAggregateDatatype)__typeMapper.readObject(__in, datatype__typeInfo, com.sforce.soap.metadata.ReportAggregateDatatype.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, description__typeInfo)) {
            setDescription(__typeMapper.readString(__in, description__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, developerName__typeInfo)) {
            setDeveloperName(__typeMapper.readString(__in, developerName__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, downGroupingContext__typeInfo)) {
            setDownGroupingContext(__typeMapper.readString(__in, downGroupingContext__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, isActive__typeInfo)) {
            setIsActive(__typeMapper.readBoolean(__in, isActive__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, isCrossBlock__typeInfo)) {
            setIsCrossBlock(__typeMapper.readBoolean(__in, isCrossBlock__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, masterLabel__typeInfo)) {
            setMasterLabel(__typeMapper.readString(__in, masterLabel__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, reportType__typeInfo)) {
            setReportType(__typeMapper.readString(__in, reportType__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, scale__typeInfo)) {
            setScale((int)__typeMapper.readInt(__in, scale__typeInfo, int.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[ReportAggregate ");
      sb.append(" acrossGroupingContext='").append(com.sforce.ws.util.Verbose.toString(acrossGroupingContext)).append("'\n");
      sb.append(" calculatedFormula='").append(com.sforce.ws.util.Verbose.toString(calculatedFormula)).append("'\n");
      sb.append(" datatype='").append(com.sforce.ws.util.Verbose.toString(datatype)).append("'\n");
      sb.append(" description='").append(com.sforce.ws.util.Verbose.toString(description)).append("'\n");
      sb.append(" developerName='").append(com.sforce.ws.util.Verbose.toString(developerName)).append("'\n");
      sb.append(" downGroupingContext='").append(com.sforce.ws.util.Verbose.toString(downGroupingContext)).append("'\n");
      sb.append(" isActive='").append(com.sforce.ws.util.Verbose.toString(isActive)).append("'\n");
      sb.append(" isCrossBlock='").append(com.sforce.ws.util.Verbose.toString(isCrossBlock)).append("'\n");
      sb.append(" masterLabel='").append(com.sforce.ws.util.Verbose.toString(masterLabel)).append("'\n");
      sb.append(" reportType='").append(com.sforce.ws.util.Verbose.toString(reportType)).append("'\n");
      sb.append(" scale='").append(com.sforce.ws.util.Verbose.toString(scale)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}