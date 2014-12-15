package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class FlowActionCall extends com.sforce.soap.metadata.FlowNode {

    /**
     * Constructor
     */
    public FlowActionCall() {}

    /**
     * element : actionName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo actionName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","actionName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean actionName__is_set = false;

    private java.lang.String actionName;

    public java.lang.String getActionName() {
      return actionName;
    }

    public void setActionName(java.lang.String actionName) {
      this.actionName = actionName;
      actionName__is_set = true;
    }

    /**
     * element : actionType of type {http://soap.sforce.com/2006/04/metadata}InvocableActionType
     * java type: com.sforce.soap.metadata.InvocableActionType
     */
    private static final com.sforce.ws.bind.TypeInfo actionType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","actionType","http://soap.sforce.com/2006/04/metadata","InvocableActionType",1,1,true);

    private boolean actionType__is_set = false;

    private com.sforce.soap.metadata.InvocableActionType actionType;

    public com.sforce.soap.metadata.InvocableActionType getActionType() {
      return actionType;
    }

    public void setActionType(com.sforce.soap.metadata.InvocableActionType actionType) {
      this.actionType = actionType;
      actionType__is_set = true;
    }

    /**
     * element : connector of type {http://soap.sforce.com/2006/04/metadata}FlowConnector
     * java type: com.sforce.soap.metadata.FlowConnector
     */
    private static final com.sforce.ws.bind.TypeInfo connector__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","connector","http://soap.sforce.com/2006/04/metadata","FlowConnector",0,1,true);

    private boolean connector__is_set = false;

    private com.sforce.soap.metadata.FlowConnector connector;

    public com.sforce.soap.metadata.FlowConnector getConnector() {
      return connector;
    }

    public void setConnector(com.sforce.soap.metadata.FlowConnector connector) {
      this.connector = connector;
      connector__is_set = true;
    }

    /**
     * element : faultConnector of type {http://soap.sforce.com/2006/04/metadata}FlowConnector
     * java type: com.sforce.soap.metadata.FlowConnector
     */
    private static final com.sforce.ws.bind.TypeInfo faultConnector__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","faultConnector","http://soap.sforce.com/2006/04/metadata","FlowConnector",0,1,true);

    private boolean faultConnector__is_set = false;

    private com.sforce.soap.metadata.FlowConnector faultConnector;

    public com.sforce.soap.metadata.FlowConnector getFaultConnector() {
      return faultConnector;
    }

    public void setFaultConnector(com.sforce.soap.metadata.FlowConnector faultConnector) {
      this.faultConnector = faultConnector;
      faultConnector__is_set = true;
    }

    /**
     * element : inputParameters of type {http://soap.sforce.com/2006/04/metadata}FlowActionCallInputParameter
     * java type: com.sforce.soap.metadata.FlowActionCallInputParameter[]
     */
    private static final com.sforce.ws.bind.TypeInfo inputParameters__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","inputParameters","http://soap.sforce.com/2006/04/metadata","FlowActionCallInputParameter",0,-1,true);

    private boolean inputParameters__is_set = false;

    private com.sforce.soap.metadata.FlowActionCallInputParameter[] inputParameters = new com.sforce.soap.metadata.FlowActionCallInputParameter[0];

    public com.sforce.soap.metadata.FlowActionCallInputParameter[] getInputParameters() {
      return inputParameters;
    }

    public void setInputParameters(com.sforce.soap.metadata.FlowActionCallInputParameter[] inputParameters) {
      this.inputParameters = inputParameters;
      inputParameters__is_set = true;
    }

    /**
     * element : outputParameters of type {http://soap.sforce.com/2006/04/metadata}FlowActionCallOutputParameter
     * java type: com.sforce.soap.metadata.FlowActionCallOutputParameter[]
     */
    private static final com.sforce.ws.bind.TypeInfo outputParameters__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","outputParameters","http://soap.sforce.com/2006/04/metadata","FlowActionCallOutputParameter",0,-1,true);

    private boolean outputParameters__is_set = false;

    private com.sforce.soap.metadata.FlowActionCallOutputParameter[] outputParameters = new com.sforce.soap.metadata.FlowActionCallOutputParameter[0];

    public com.sforce.soap.metadata.FlowActionCallOutputParameter[] getOutputParameters() {
      return outputParameters;
    }

    public void setOutputParameters(com.sforce.soap.metadata.FlowActionCallOutputParameter[] outputParameters) {
      this.outputParameters = outputParameters;
      outputParameters__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "http://soap.sforce.com/2006/04/metadata", "FlowActionCall");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeString(__out, actionName__typeInfo, actionName, actionName__is_set);
       __typeMapper.writeObject(__out, actionType__typeInfo, actionType, actionType__is_set);
       __typeMapper.writeObject(__out, connector__typeInfo, connector, connector__is_set);
       __typeMapper.writeObject(__out, faultConnector__typeInfo, faultConnector, faultConnector__is_set);
       __typeMapper.writeObject(__out, inputParameters__typeInfo, inputParameters, inputParameters__is_set);
       __typeMapper.writeObject(__out, outputParameters__typeInfo, outputParameters, outputParameters__is_set);
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
        if (__typeMapper.verifyElement(__in, actionName__typeInfo)) {
            setActionName(__typeMapper.readString(__in, actionName__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, actionType__typeInfo)) {
            setActionType((com.sforce.soap.metadata.InvocableActionType)__typeMapper.readObject(__in, actionType__typeInfo, com.sforce.soap.metadata.InvocableActionType.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, connector__typeInfo)) {
            setConnector((com.sforce.soap.metadata.FlowConnector)__typeMapper.readObject(__in, connector__typeInfo, com.sforce.soap.metadata.FlowConnector.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, faultConnector__typeInfo)) {
            setFaultConnector((com.sforce.soap.metadata.FlowConnector)__typeMapper.readObject(__in, faultConnector__typeInfo, com.sforce.soap.metadata.FlowConnector.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, inputParameters__typeInfo)) {
            setInputParameters((com.sforce.soap.metadata.FlowActionCallInputParameter[])__typeMapper.readObject(__in, inputParameters__typeInfo, com.sforce.soap.metadata.FlowActionCallInputParameter[].class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, outputParameters__typeInfo)) {
            setOutputParameters((com.sforce.soap.metadata.FlowActionCallOutputParameter[])__typeMapper.readObject(__in, outputParameters__typeInfo, com.sforce.soap.metadata.FlowActionCallOutputParameter[].class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[FlowActionCall ");
      sb.append(super.toString());sb.append(" actionName='").append(com.sforce.ws.util.Verbose.toString(actionName)).append("'\n");
      sb.append(" actionType='").append(com.sforce.ws.util.Verbose.toString(actionType)).append("'\n");
      sb.append(" connector='").append(com.sforce.ws.util.Verbose.toString(connector)).append("'\n");
      sb.append(" faultConnector='").append(com.sforce.ws.util.Verbose.toString(faultConnector)).append("'\n");
      sb.append(" inputParameters='").append(com.sforce.ws.util.Verbose.toString(inputParameters)).append("'\n");
      sb.append(" outputParameters='").append(com.sforce.ws.util.Verbose.toString(outputParameters)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}