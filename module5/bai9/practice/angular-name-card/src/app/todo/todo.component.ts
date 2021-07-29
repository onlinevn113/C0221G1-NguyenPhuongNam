import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TodoService} from '../todo.service';
import Swal from 'sweetalert2';


// @ts-ignore
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  name: string;
  todo: Todo;

  constructor(private s: TodoService) {
  }

  ngOnInit() {
    this.showList();
  }

  showList() {
    this.s.getAll().subscribe(t => {
      this.todos = t;
    });
  }

  create(name: string) {
    Swal.fire({
      text: 'Create new Todo' +
        '<br><input type="text" placeholder="name">',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      this.todo.name = name;
      this.s.save(this.todo).subscribe();
      Swal.fire(
        'Createed!',
        '',
        'success'
      );
    });
  }

  update(id: number) {
    this.s.findById(id).subscribe(c => {
      this.name = c.name;
    });
    Swal.fire({
      text: 'Create new Todo' +
        '<br><input type="text" value="{{name}}" placeholder="name">',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.s.findById(id).subscribe(c => {
          this.s.update(id, c);
        });
        Swal.fire(
          'Updated!',
          '',
          'success'
        );
      }
    });

  }

  delete(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You won\'t be able to revert this!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.s.delete(id);
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        );
      }
    });
  }

}
