/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 *             AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/openAUSIAS
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


function fObraRoutes() {
    var icon = '<i class="fa fa-file-text-o fa-5x"></i>';
    var fillObraPageHeader = _.partial(init.getPageHeader, icon, 'Obra', _);
    var strClass = 'obra';
    var header=$('#broth_panel_heading');
    var content = $('#broth_content');
    //--------------------------------------------------------------------------
    Path.map("#/" + strClass + "/remove/:id").to(function () {
        header.empty().append(fillObraPageHeader('Remove'));
        var strParam = init.getUrlObjectFromUrlString(this.params['url']);
        ausiasFLOW.reset();
        ausiasFLOW.initialize(removeModule, content, strClass, 'remove', strParam);
        return false;
    });
    //--------------------------------------------------------------------------
    Path.map("#/" + strClass + "/new(/:url)").to(function () {
        header.empty().append(fillObraPageHeader('New'));
        var strParam = init.getUrlObjectFromUrlString(this.params['url']);
        ausiasFLOW.reset();
        ausiasFLOW.initialize(obraNew, content, strClass, 'new', strParam);
        return false;
    });
    //--------------------------------------------------------------------------    
    Path.map("#/" + strClass + "/edit/:url").to(function () {
        header.empty().append(fillObraPageHeader('Edit'));
        var strParam = init.getUrlObjectFromUrlString(this.params['url']);
        ausiasFLOW.reset();
        ausiasFLOW.initialize(obraEdit, content, strClass, 'edit', strParam);
        return false;
    });
    //--------------------------------------------------------------------------
    Path.map("#/" + strClass + "/view/:id").to(function () {
        header.empty().append(fillObraPageHeader('View'));
        var strParam = init.getUrlObjectFromUrlString(this.params['url']);
        ausiasFLOW.reset();
        ausiasFLOW.initialize(viewModule, content, strClass, 'view', strParam);
        return false;
    });
    //--------------------------------------------------------------------------    
    Path.map("#/" + strClass + "/list(/:url)").to(function () {
        header.empty().append(fillObraPageHeader('List'));
        var strParam = init.defaultizeUrlObjectParametersForLists(init.getUrlObjectFromUrlString(this.params['url']));
        ausiasFLOW.reset();
        ausiasFLOW.initialize(listModule, content, strClass, 'list', strParam);
        return false;
    });
    //--------------------------------------------------------------------------
    Path.map("#/" + strClass + "/plist(/:url)").to(function () {
        header.empty().append(fillObraPageHeader('Paginated List'));
        var strParam = init.getUrlObjectFromUrlString(this.params['url']);
        ausiasFLOW.reset();
        ausiasFLOW.initialize(pListModule, content, strClass, 'plist', strParam);
        return false;
    });
    //--------------------------------------------------------------------------
    Path.map("#/" + strClass + "/plist_labels_authors_x_ndocs(/:url)").to(function () {
        header.empty().append(fillObraPageHeader('Paginated List'));
        var strParam = init.getUrlObjectFromUrlString(this.params['url']);
        ausiasFLOW.reset();
        ausiasFLOW.initialize(pListModule, content, strClass, 'plist_labels_authors_x_ndocs', strParam);
        return false;
    });
    //--------------------------------------------------------------------------
    Path.map("#/" + strClass + "/abc(/:url)").to(function () {
        var strParam = init.getUrlObjectFromUrlString(this.params['url']);
        if (strParam) {
            strParam.vf = 4;
        } else {
            strParam = {'vf': 4};
        }
        header.empty().append(fillObraPageHeader('Composed operation'));
        content.empty().append('<div class="col-md-8" id="c1"></div><div class="col-md-4" id="c2"></div>')
        ausiasFLOW.reset();
        ausiasFLOW.initialize(obraPaginatedList, $('#c1'), strClass, 'abc', strParam);
        ausiasFLOW.initialize(viewModule, $('#c2'), strClass, 'view', strParam);
        return false;
    });
    //--------------------------------------------------------------------------
    Path.map("#/" + strClass + "/obrasautor").to(function () {
        header.empty().append(fillObraPageHeader('Obras de cada autor'));
        var strParam = init.getUrlObjectFromUrlString(this.params['url']);
        ausiasFLOW.reset();
        ausiasFLOW.initialize(obrasautorList, content, 'obrasautor', 'list', strParam);
        return false;
    });


}