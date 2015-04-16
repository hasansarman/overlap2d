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

package com.uwsoft.editor.mvc.view.ui.properties;

import com.puremvc.patterns.mediator.SimpleMediator;
import com.puremvc.patterns.observer.Notification;
import com.uwsoft.editor.Overlap2D;
import com.uwsoft.editor.gdx.sandbox.Sandbox;

/**
 * Created by azakhary on 4/15/2015.
 */
public abstract class UIAbstractPropertiesMediator<T, V extends UIAbstractProperties> extends SimpleMediator<V> {
    private Sandbox sandbox;

    private T itemReference;

    public UIAbstractPropertiesMediator(String mediatorName, V viewComponent) {
        super(mediatorName, viewComponent);

        sandbox = Sandbox.getInstance();
    }


    @Override
    public String[] listNotificationInterests() {
        return new String[]{
                Overlap2D.ITEM_DATA_UPDATED,
                UIAbstractProperties.PROPERTIES_UPDATED
        };
    }

    @Override
    public void handleNotification(Notification notification) {
        super.handleNotification(notification);

        switch (notification.getName()) {
            case UIAbstractProperties.PROPERTIES_UPDATED:

                break;
            case Overlap2D.ITEM_DATA_UPDATED:
                onItemDataUpdate();
                break;
            default:
                break;
        }
    }

    public void setItem(T item) {
        itemReference = item;
        translateItemDataToView(itemReference);
    }

    public void onItemDataUpdate() {
        translateItemDataToView(itemReference);
    }

    protected abstract void translateItemDataToView(T item);
}
