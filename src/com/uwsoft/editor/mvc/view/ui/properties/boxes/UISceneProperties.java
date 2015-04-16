/*
 * ******************************************************************************
 *  * Copyright 2015 See AUTHORS file.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *****************************************************************************
 */

package com.uwsoft.editor.mvc.view.ui.properties.boxes;

import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.kotcrab.vis.ui.widget.VisCheckBox;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTextField;
import com.uwsoft.editor.mvc.event.CheckBoxChangeListener;
import com.uwsoft.editor.mvc.event.KeyboardListener;
import com.uwsoft.editor.mvc.view.ui.properties.UIAbstractProperties;

/**
 * Created by azakhary on 4/16/2015.
 */
public class UISceneProperties extends UIAbstractProperties {

    private VisCheckBox physicsEnabledCheckBox;
    private VisTextField gravityXTextField;
    private VisTextField gravityYTextField;
    private VisTextField sleepVelocityTextField;
    private VisCheckBox enableLightsCheckBox;
    private VisCheckBox diffuseCheckBox;

    public UISceneProperties() {
        super();

        pad(5);
        add(new VisLabel("Physics enabled:", Align.right)).padRight(5).width(115);
        physicsEnabledCheckBox = new VisCheckBox(null);
        add(physicsEnabledCheckBox).left();
        row().padTop(5);
        add(new VisLabel("Gravity X:", Align.right)).padRight(5).width(115);
        gravityXTextField = new VisTextField();
        add(gravityXTextField).width(115);
        row().padTop(5);
        add(new VisLabel("Gravity Y:", Align.right)).padRight(5).width(115);
        gravityYTextField = new VisTextField();
        add(gravityYTextField).width(115);
        row().padTop(5);
        add(new VisLabel("Sleep velocity:", Align.right)).padRight(5).width(115);
        sleepVelocityTextField = new VisTextField();
        add(sleepVelocityTextField).width(115);
        row().padTop(5);
        addSeparator().colspan(2).padTop(5).padBottom(5);
        add(new VisLabel("Enable lights:", Align.right)).padRight(5).width(115);
        enableLightsCheckBox = new VisCheckBox(null);
        add(enableLightsCheckBox).left();
        row().padTop(5);
        add(new VisLabel("Diffuse:", Align.right)).padRight(5).width(115);
        diffuseCheckBox = new VisCheckBox(null);
        add(diffuseCheckBox).left();

        setListeners();
    }

    public boolean isDiffuse() {
        return diffuseCheckBox.isChecked();
    }

    public void setDiffuse(boolean isDiffuse) {
        this.diffuseCheckBox.setChecked(isDiffuse);
    }

    public boolean isPhysicsEnabled() {
        return physicsEnabledCheckBox.isChecked();
    }

    public void setPhysicsEnable(boolean isPhysicsEnabled) {
        this.physicsEnabledCheckBox.setChecked(isPhysicsEnabled);
    }

    public String getGravityXValue() {
        return gravityXTextField.getText();
    }

    public void setGravityXValue(String gravityXValue) {
        this.gravityXTextField.setText(gravityXValue);
    }

    public String getGravityYValue() {
        return gravityYTextField.getText();
    }

    public void setGravityYValue(String gravityYValue) {
        this.gravityXTextField.setText(gravityYValue);
    }

    public String getSleepVelocityValue() {
        return sleepVelocityTextField.getText();
    }

    public void setSleepVelocityValue(String sleepVelocityValue) {
        this.sleepVelocityTextField.setText(sleepVelocityValue);
    }

    public boolean isLightsEnabled() {
        return enableLightsCheckBox.isChecked();
    }

    public void setLightsEnabled(boolean isLightsEnabled) {
        this.enableLightsCheckBox.setChecked(isLightsEnabled);
    }

    private void setListeners() {
        physicsEnabledCheckBox.addListener(new CheckBoxChangeListener(UIAbstractProperties.PROPERTIES_UPDATED));
        gravityXTextField.addListener(new KeyboardListener(UIAbstractProperties.PROPERTIES_UPDATED));
        gravityYTextField.addListener(new KeyboardListener(UIAbstractProperties.PROPERTIES_UPDATED));
        sleepVelocityTextField.addListener(new KeyboardListener(UIAbstractProperties.PROPERTIES_UPDATED));
        enableLightsCheckBox.addListener(new CheckBoxChangeListener(UIAbstractProperties.PROPERTIES_UPDATED));
        diffuseCheckBox.addListener(new CheckBoxChangeListener(UIAbstractProperties.PROPERTIES_UPDATED));
    }
}
