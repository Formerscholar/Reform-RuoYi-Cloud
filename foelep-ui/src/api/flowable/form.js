/*
 * @Author: chad 2319315514@qq.com
 * @Date: 2022-06-12 11:24:58
 * @LastEditors: chad 2319315514@qq.com
 * @LastEditTime: 2022-06-12 11:28:01
 * @FilePath: \foelep-ui\src\api\flowable\form.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import request from '@/utils/request'

// 查询流程表单列表
export function listForm(query) {
  return request({
    url: '/system/flowable/form/list',
    method: 'get',
    params: query
  })
}

// 查询流程表单详细
export function getForm(formId) {
  return request({
    url: '/system/flowable/form/' + formId,
    method: 'get'
  })
}

// 新增流程表单
export function addForm(data) {
  return request({
    url: '/system/flowable/form',
    method: 'post',
    data: data
  })
}

// 修改流程表单
export function updateForm(data) {
  return request({
    url: '/system/flowable/form',
    method: 'put',
    data: data
  })
}
// 挂载表单
export function addDeployForm(data) {
  return request({
    url: '/system/flowable/form/addDeployForm',
    method: 'post',
    data: data
  })
}

// 删除流程表单
export function delForm(formId) {
  return request({
    url: '/system/flowable/form/' + formId,
    method: 'delete'
  })
}

// 导出流程表单
export function exportForm(query) {
  return request({
    url: '/system/flowable/form/export',
    method: 'get',
    params: query
  })
}
