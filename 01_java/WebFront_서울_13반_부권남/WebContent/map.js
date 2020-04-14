/**
 * MyMap 생성자로 사용될 함수를 구현
 */

function MyMap() {
  this.data = {}; 	// 빈 객체 생성
  this.count = 0;	// 현재 개수 카운트
}

MyMap.prototype = {
  put(key, value) {
    this.data[key] = value;		// data를 딕셔너리 구조로 k,v 생성
    this.count++;				// 개수 1 증가
  },
  size() {
	  return this.count;		// size == count 출력
  },
  get(key) {
	  return this.data[key];	// 키값에 대한 value 출력
  },
  remove(key) {
	  delete this.data[key];	// 키값에 대한 요소 삭제
	  this.count--;	
	  return;
  },
  clear() {
	 this.data ={};				// 그냥 빈객체로 초기화
	 this.count = 0;			// 개수도 초기화
	 return;
  }
};