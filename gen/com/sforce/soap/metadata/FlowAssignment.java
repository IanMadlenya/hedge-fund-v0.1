package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class FlowAssignment extends com.sforce.soap.metadata.FlowNode {

    /**
     * Constructor
     */
    public FlowAssignment() {}

    /**
     * element : assignmentItems of type {http://soap.sforce.com/2006/04/metadata}FlowAssignmentItem
     * java type: com.sforce.soap.metadata.FlowAssignmentItem[]
     */
    private static final com.sforce.ws.bind.TypeInfo assignmentItems__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","assignmentItems","http://soap.sforce.com/2006/04/metadata","FlowAssignmentItem",0,-1,true);

    private boolean assignmentItems__is_set = false;

    private com.sforce.soap.metadata.FlowAssignmentItem[] assignmentItems = new com.sforce.soap.metadata.FlowAssignmentItem[0];

    public com.sforce.soap.metadata.FlowAssignmentItem[] getAssignmentItems() {
      return assignmentItems;
    }

    public void setAssignmentItems(com.sforce.soap.metadata.FlowAssignmentItem[] assignmentItems) {
      this.assignmentItems = assignmentItems;
      assignmentItems__is_set = true;
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
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "http://soap.sforce.com/2006/04/metadata", "FlowAssignment");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeObject(__out, assignmentItems__typeInfo, assignmentItems, assignmentItems__is_set);
       __typeMapper.writeObject(__out, connector__typeInfo, connector, connector__is_set);
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
        if (__typeMapper.isElement(__in, assignmentItems__typeInfo)) {
            setAssignmentItems((com.sforce.soap.metadata.FlowAssignmentItem[])__typeMapper.readObject(__in, assignmentItems__typeInfo, com.sforce.soap.metadata.FlowAssignmentItem[].class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, connector__typeInfo)) {
            setConnector((com.sforce.soap.metadata.FlowConnector)__typeMapper.readObject(__in, connector__typeInfo, com.sforce.soap.metadata.FlowConnector.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[FlowAssignment ");
      sb.append(super.toString());sb.append(" assignmentItems='").append(com.sforce.ws.util.Verbose.toString(assignmentItems)).append("'\n");
      sb.append(" connector='").append(com.sforce.ws.util.Verbose.toString(connector)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}