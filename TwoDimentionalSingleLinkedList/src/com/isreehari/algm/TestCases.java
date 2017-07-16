/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;

/**
 *
 * @author sinukoll
 */
public class TestCases {
    public Node startNode;
    public TestCases nextTestCaseRef;
    
    public TestCases(Node newTestCaseStartNode){
        this.startNode = newTestCaseStartNode;
        this.nextTestCaseRef = null;
    }
}
